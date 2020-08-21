package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.Student;
import cn.sus.edu.partymemberdevelopment.service.Impl.StudentServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.EmptyUtils;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "学生角色接口文档")
@CrossOrigin
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Map<String, Object> findAll(@RequestBody Map<String, Object> params) throws RuntimeException {
        return studentService.findAll(params);
    }


    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Map<String, Object> findOne(@RequestBody Map<String, Object> params) throws RuntimeException {
        Student exitStudent = studentService.findOne(params);
        if (EmptyUtils.isEmpty(exitStudent)) {
            ResponseUtils.getFailure("未查询到该条数据");
        }
        return ResponseUtils.getSuccess("查询成功", exitStudent);
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map<String, Object> addStudent(@RequestBody Student student) throws RuntimeException {
        int addResult = studentService.addStudent(student);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public Map<String, Object> delStudent(@RequestParam("userId") Long userId) throws RuntimeException {
        int deleteResult = studentService.deleteStudent(userId);
        if(deleteResult < 1) {
            return ResponseUtils.getFailure("删除失败");
        }
        return ResponseUtils.getSuccess("删除成功");
    }


    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public Map<String, Object> modifyStudent(@RequestBody Student student) throws RuntimeException {
        int modifyResult = studentService.modifyStudent(student);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("修改失败");
        }
        return ResponseUtils.getSuccess("修改成功");
    }

}
