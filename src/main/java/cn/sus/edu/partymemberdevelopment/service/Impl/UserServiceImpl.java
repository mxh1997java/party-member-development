package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.configuration.constant.Constant;
import cn.sus.edu.partymemberdevelopment.entity.User;
import cn.sus.edu.partymemberdevelopment.mapper.UserMapper;
import cn.sus.edu.partymemberdevelopment.service.UserService;
import cn.sus.edu.partymemberdevelopment.util.*;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;

    @Value("${salt_value}")
    String salt_value;

    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(username), "必要参数缺失!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(password), "必要参数缺失!");
        User user = new User();
        user.setUsername(username);
        EncryptUtils instance = EncryptUtils.getInstance();
        user.setPassword(instance.MD5(password, ""));
        User findOneResult = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(EmptyUtils.isEmpty(findOneResult), "账户不存在!");
        //添加session会话
        String token = UUID.randomUUID().toString();
        redisUtils.set(username, token);
        redisUtils.expire(username, 3600);
        //添加cookie
        CookieUtils.setCookie(request, response, "token", token);
        String encodeCookie = null;
        try {
            encodeCookie = URLEncoder.encode(JSON.toJSONString(findOneResult), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CookieUtils.setCookie(request, response, "userinfo", encodeCookie);
        return false;
    }

    @Override
    public List<User> findAllUser() throws RuntimeException {
        return userMapper.findAll();
    }

    @Override
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params), "params不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageNum")), "pageNum不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(params.get("pageSize")), "pageSize不为空!");
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        if(pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findAllByCondition(params);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return ResponseUtils.getSuccess("查询成功!", pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public User findOne(User user) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(user), "user不为空!");
        return userMapper.findOneByCondition(user);
    }

    @Override
    public int addUser(User user) throws RuntimeException {
        AssertUtils.assertFalse(null != user.getUsername(), "用户名不为空!");
        AssertUtils.assertFalse(null != user.getPassword(), "密码不为空!");
        User findOneResult = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(findOneResult != null, "用户名" + user.getUsername() + "已存在!");
        EncryptUtils instance = EncryptUtils.getInstance();
        //盐值+密码
        String encryption = instance.MD5(user.getPassword(), salt_value);
        user.setPassword(encryption);
        user.setCreateTime(LocalDateTime.now());
        return userMapper.addUser(user);
    }

    @Override
    public int modifyUser(User user) throws RuntimeException {
        AssertUtils.assertFalse(null != user.getUserId(), "id不为空!");
        User findResult = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(findResult == null, "修改数据不存在!");
        user.setModifyTime(LocalDateTime.now());

        String firstLevelRole = user.getFirstLevelRole().trim();
        if(!EmptyUtils.isEmpty(firstLevelRole) && !Constant.USER_INIT.equals(firstLevelRole)) {
            String modifier = user.getModifier().trim();
            AssertUtils.assertFalse(Constant.USER_ADMIN.equals(modifier), "修改失败!修改者没有管理员权限");
        }
        if(!firstLevelRole.equals(Constant.USER_ADMIN)
                && !firstLevelRole.equals(Constant.USER_TEACHER)
                && !firstLevelRole.equals(Constant.USER_STUDENT)) {
            AssertUtils.assertTrue(true, "修改失败!未知角色");
        }
        return userMapper.updateUserById(user);
    }

    @Override
    public int deleteUser(Long userId) throws RuntimeException {
        AssertUtils.assertFalse(null != userId, "缺少必要参数!");
        User user = new User();
        user.setUserId(userId);
        User existUser = userMapper.findOneByCondition(user);
        AssertUtils.assertTrue(null==existUser, "删除数据不存在!");
        return userMapper.deleteUserById(userId);
    }
}
