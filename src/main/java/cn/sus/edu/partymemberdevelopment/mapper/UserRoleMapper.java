package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 类描述: 用户角色
 * @Author: XinHai.Ma
 * @Date: 2020/8/16 16:03
 */
@Repository
@Mapper
public interface UserRoleMapper {

    List<UserRole> findAll();

    UserRole findOne(UserRole role);

    int addUserRole(UserRole role);

    int deleteUserRoleById(Long roleId);

    int updateUserRoleById(UserRole role);

    int batchInsert(List<UserRole> userRoleList);

}
