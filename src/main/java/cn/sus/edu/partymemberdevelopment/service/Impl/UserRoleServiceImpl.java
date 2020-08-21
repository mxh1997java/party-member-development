package cn.sus.edu.partymemberdevelopment.service.Impl;

import cn.sus.edu.partymemberdevelopment.entity.UserRole;
import cn.sus.edu.partymemberdevelopment.mapper.UserRoleMapper;
import cn.sus.edu.partymemberdevelopment.service.UserRoleService;
import cn.sus.edu.partymemberdevelopment.util.AssertUtils;
import cn.sus.edu.partymemberdevelopment.util.EmptyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> findAll() throws RuntimeException {
        return userRoleMapper.findAll();
    }

    @Override
    public UserRole findOne(UserRole role) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(role), "role不为空!");
        return userRoleMapper.findOne(role);
    }

    @Override
    public int addRole(UserRole role) throws RuntimeException {
        AssertUtils.assertTrue(null==role, "role不为空!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(role.getRoleName()), "角色名称不为空!");
        role.setCreateTime(LocalDateTime.now());
        return userRoleMapper.addUserRole(role);
    }

    @Override
    public int modifyRole(UserRole role) throws RuntimeException {
        AssertUtils.assertTrue(EmptyUtils.isEmpty(role), "缺少必要参数!");
        AssertUtils.assertTrue(EmptyUtils.isEmpty(role.getRoleId()), "缺少必要参数!");
        UserRole condition = new UserRole();
        condition.setRoleId(role.getRoleId());
        UserRole existUserRole = userRoleMapper.findOne(condition);
        AssertUtils.assertTrue(null==existUserRole, "修改数据不存在!");
        role.setModifyTime(LocalDateTime.now());
        return userRoleMapper.updateUserRoleById(role);
    }

    @Override
    public int deleteRole(Long roleId) throws RuntimeException {
        AssertUtils.assertTrue(null==roleId, "缺少必要参数!");
        UserRole role = new UserRole();
        role.setRoleId(roleId);
        UserRole existUserRole = userRoleMapper.findOne(role);
        AssertUtils.assertTrue(null==existUserRole, "删除数据不存在!");
        return userRoleMapper.deleteUserRoleById(roleId);
    }

}
