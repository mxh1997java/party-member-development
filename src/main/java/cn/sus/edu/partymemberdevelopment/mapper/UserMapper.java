package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from D_USER")
    List<User> findAll();

    User findOneByCondition(User user);

    List<User> findAllByCondition(Map<String, Object> params);

    int addUser(User user);

    int deleteUserById(Long id);

    int updateUserById(User user);

    int batchInsert(List<User> userList);

}
