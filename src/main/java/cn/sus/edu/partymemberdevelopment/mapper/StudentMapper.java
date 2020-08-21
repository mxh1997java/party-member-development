package cn.sus.edu.partymemberdevelopment.mapper;

import cn.sus.edu.partymemberdevelopment.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: 学生信息持久层
 * @Author: XinHai.Ma
 * @Date: 2020/8/16 11:29
 */
@Repository
@Mapper
public interface StudentMapper {

    Student findOneByCondition(Student student);

    List<Student> findAllByCondition(Map<String, Object> params);

    int addStudent(Student student);

    int deleteStudentById(Long id);

    int updateStudentById(Student student);

}
