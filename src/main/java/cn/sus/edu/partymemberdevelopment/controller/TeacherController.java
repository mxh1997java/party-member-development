package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.Teacher;
import cn.sus.edu.partymemberdevelopment.service.Impl.TeacherServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "教师角色接口文档")
@CrossOrigin
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Map<String, Object> findAll(@RequestBody Map<String, Object> params) throws RuntimeException {
        return teacherService.findAll(params);
    }


    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Map<String, Object> findOne(@RequestBody Teacher teacher) throws RuntimeException {
        Teacher existTeacher = teacherService.findOne(teacher);
        return null;
    }


    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public Map<String, Object> addTeacher(@RequestBody Teacher teacher) throws RuntimeException {
        int addResult = teacherService.addTeacher(teacher);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/delTeacher", method = RequestMethod.POST)
    public Map<String, Object> delTeacher(@RequestParam("userId") Long userId) throws RuntimeException {
        int deleteResult = teacherService.deleteTeacher(userId);
        if(deleteResult < 1) {
            return ResponseUtils.getFailure("删除失败");
        }
        return ResponseUtils.getSuccess("删除成功");
    }


    @RequestMapping(value = "/modifyTeacher", method = RequestMethod.POST)
    public Map<String, Object> modifyTeacher(@RequestBody Teacher teacher) throws RuntimeException {
        int modifyResult = teacherService.modifyTeacher(teacher);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("修改失败");
        }
        return ResponseUtils.getSuccess("修改成功");
    }


}
