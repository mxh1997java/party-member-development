package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.Student;
import cn.sus.edu.partymemberdevelopment.service.Impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 学生接口测试(没问题)
 * @Author: 15735400536
 * @Date: 2020/8/17 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentServiceImpl studentService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        Student student = new Student();
        student.setStudentId(3L);
        student.setStudentName("钱小明");
        student.setUserId(6L);
        student.setCreator("admin");
        student.setJobNumber("T20200817001");
        student.setJoinGroupDate(LocalDateTime.now());
        student.setJoinJobDate(LocalDateTime.now());
        student.setJoinPartyDate(LocalDateTime.now());
        student.setApplyJoinPartyDate(LocalDateTime.now());
        student.setBornDate(LocalDate.now());
        student.setBirthday(LocalDateTime.now());
        student.setPhoneNumber("12735400536");
        student.setFamilyMember("主要成员:爸爸、妈妈、姐姐,爸爸苏州市长，妈妈苏州银行副行长，姐姐苏州分舵部门主管");
        student.setHometown("江苏省苏州市姑苏区");
        student.setAffiliatedBranch("学院组织部");
        student.setPartyPosition("党员");
        student.setResume("个人简历:http://127.0.0.1:8080/file/export");
        student.setDepartmentPosition("小喽啰");
        int addResult = studentService.addStudent(student);
        print(addResult);
    }


    @Test
    public void update(){
        Student student = new Student();
        student.setStudentId(3L);
        student.setStudentName("钱小明");
        student.setUserId(6L);
        student.setModifier("admin");
        student.setDepartmentPosition("组织部部长");
        int modifyResult = studentService.modifyStudent(student);
        print(modifyResult);
    }


    @Test
    public void delete() {
        int deleteResult = studentService.deleteStudent(1L);
        print(deleteResult);
    }


    @Test
    public void findOne() {
        Map<String, Object> params = new HashMap<>();
        params.put("studentId", 1L);
        params.put("studentName", "马小明");
        Student student = studentService.findOne(params);
        System.out.println(student);
    }

    @Test
    public void findAll() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 2);
        params.put("pageSize", 1);
        params.put("beginTime", "2020-8-17 00:00:00");
        params.put("endTime", "2020-8-20 00:00:00");
        Map<String, Object> response = studentService.findAll(params);
        System.out.println(response);
    }

}
