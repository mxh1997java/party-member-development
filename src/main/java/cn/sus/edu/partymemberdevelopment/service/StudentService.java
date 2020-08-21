package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.Student;

import java.util.Map;

public interface StudentService {

    Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException;

    Student findOne(Map<String, Object> params) throws RuntimeException;

    int addStudent(Student student) throws RuntimeException;

    int modifyStudent(Student student) throws RuntimeException;

    int deleteStudent(Long studentId) throws RuntimeException;

}
