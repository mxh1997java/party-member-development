package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.User;
import cn.sus.edu.partymemberdevelopment.mapper.UserMapper;
import cn.sus.edu.partymemberdevelopment.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 功能描述: 用户接口测试(没问题)
 * @Author: 15735400536
 * @Date: 2020/8/17 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUser() {
        User user = new User();
        user.setUserId(2l);
        user.setUsername("scott");
        user.setPassword("admin");
        user.setUserSex("男");
        user.setUserAge(24);
        user.setPhoneNumber("(86-21)65508900");
        user.setCreator("admin");
        user.setMail("rsc@sus.edu.cn");
        user.setFirstLevelRole("管理员");
        int addResult = userService.addUser(user);
        System.out.println("影响行数: " + addResult);
    }

    @Test
    public void batchInsert() {
        String[] userArray = {"郭小明","李小明","赵小明","钱小明","孙小明","马小明","张志伟"};
        List<User> userList = new ArrayList<>(userArray.length);
        long id = 3;
        for(int i=0; i<userArray.length; i++) {
            User user = new User();
            user.setUserId(id);
            user.setUsername(userArray[i]);
            user.setMail("rsc@sus.edu.cn");
            user.setPhoneNumber("86-21-65508121");
            user.setUserSex("男");
            user.setUserAge(24);
            user.setPassword("123456");
            user.setCreator("admin");
            user.setFirstLevelRole("未指定角色");
            user.setCreateTime(LocalDateTime.now());
            userList.add(user);
            id++;
        }
        System.out.println(Arrays.asList(userList));
        int addResult = userMapper.batchInsert(userList);
        System.out.println("影响行数: " + addResult);
    }


    @Test
    public void findAllTest() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 2);
        params.put("pageSize", 1);
        params.put("beginTime", "2020-8-17 00:00:00");
        params.put("endTime", "2020-8-20 00:00:00");
        Map<String, Object> response = userService.findAll(params);
        System.out.println(response.toString());
    }


    @Test
    public void findOneTest() {
        User user = new User();
        user.setUserId(8l);
        user.setUsername("马小明");
        User existUser = userService.findOne(user);
        System.out.println(existUser);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setUserId(3l);
        user.setFirstLevelRole("教师");
        user.setModifier("管理员");
        int modifyResult = userService.modifyUser(user);
        System.out.println("影响行数: " + modifyResult);
    }


    @Test
    public void deleteTest() {
        int deleteResult = userService.deleteUser(2L);
        System.out.println("影响行数: " + deleteResult);
    }

}
