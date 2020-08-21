package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TeacherMapper {

    Teacher findOneByCondition(Teacher teacher);

    List<Teacher> findAllByCondition(Map<String, Object> params);

    int addTeacher(Teacher teacher);

    int deleteTeacherById(Long id);

    int updateTeacherById(Teacher teacher);

}
