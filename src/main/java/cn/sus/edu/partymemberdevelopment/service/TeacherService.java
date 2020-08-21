package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import java.util.Map;

public interface TeacherService {

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    Teacher findOne(Teacher teacher) throws RuntimeException;

    int addTeacher(Teacher teacher) throws RuntimeException;

    int modifyTeacher(Teacher teacher) throws RuntimeException;

    int deleteTeacher(Long userId) throws RuntimeException;

}
