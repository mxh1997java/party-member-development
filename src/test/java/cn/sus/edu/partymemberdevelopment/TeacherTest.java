package cn.sus.edu.partymemberdevelopment;

import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import cn.sus.edu.partymemberdevelopment.mapper.TeacherMapper;
import cn.sus.edu.partymemberdevelopment.service.Impl.TeacherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 教师接口测试(没问题)
 * @Author: 15735400536
 * @Date: 2020/8/17 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherServiceImpl teacherService;

    private void print(int row) {
        System.out.println("影响行数: " + row);
    }

    @Test
    public void add() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(3L);
        teacher.setTeacherName("赵小明");
        teacher.setUserId(5L);
        teacher.setCreator("admin");
        int addResult = teacherService.addTeacher(teacher);
        print(addResult);
    }

    @Test
    public void update() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1L);
        teacher.setTeacherName("郭小明");
        teacher.setUserId(3L);
        teacher.setModifier("admin");
        teacher.setCollegeDirectlyUnderPartyBranchOrganizer("是");
        int addResult = teacherService.modifyTeacher(teacher);
        print(addResult);
    }

    @Test
    public void delete() {
        int addResult = teacherService.deleteTeacher(1L);
        print(addResult);
    }

    @Test
    public void findAll() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageNum", 2);
        params.put("pageSize", 1);
        params.put("beginTime", "2020-8-17 00:00:00");
        params.put("endTime", "2020-8-20 00:00:00");
        Map<String, Object> response = teacherService.findAll(params);
        System.out.println(response);
    }

    @Test
    public void findOne() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1L);
        teacher.setTeacherName("郭小明");
        Teacher existTeacher = teacherService.findOne(teacher);
        System.out.println(existTeacher);
    }

}
