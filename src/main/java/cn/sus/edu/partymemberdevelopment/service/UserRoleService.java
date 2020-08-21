package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.UserRole;
import java.util.List;

public interface UserRoleService {

    List<UserRole> findAll() throws RuntimeException;

    UserRole findOne(UserRole role) throws RuntimeException;

    int addRole(UserRole role) throws RuntimeException;

    int modifyRole(UserRole role) throws RuntimeException;

    int deleteRole(Long roleId) throws RuntimeException;

}
