package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.User;
import cn.sus.edu.partymemberdevelopment.service.Impl.UserServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户接口文档")
@CrossOrigin
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Map<String, Object> findAll() throws RuntimeException {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("code", 200);
        result.put("data", userService.findAllUser());
        if(result != null) {
            throw new RuntimeException("XinHai.Ma");
        }
        return result;
    }


    @ApiOperation(value = "分页 多条件 查询用户信息", notes = "findAll", httpMethod = "GET")
    @ApiImplicitParam(dataType = "java.util.Map",name = "params",value = "params",required = true)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Map<String, Object> findAll(@RequestBody Map<String, Object> params) throws RuntimeException {
        return userService.findAll(params);
    }


    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Map<String, Object> findOne(@RequestBody User user) throws RuntimeException {
        User existUser = userService.findOne(user);
        return ResponseUtils.getSuccess("查询成功", existUser);
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestBody User user) throws RuntimeException {
        int addResult = userService.addUser(user);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public Map<String, Object> delUser(Long userId) throws RuntimeException {
        int deleteResult = userService.deleteUser(userId);
        if(deleteResult < 1) {
            return ResponseUtils.getFailure("删除失败");
        }
        return ResponseUtils.getSuccess("删除成功");
    }


    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public Map<String, Object> modifyUser(@RequestBody User user) throws RuntimeException {
        int modifyResult = userService.modifyUser(user);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("修改失败");
        }
        return ResponseUtils.getSuccess("修改成功");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password) throws RuntimeException {
        boolean loginResult = userService.login(request, response, username, password);
        if(!loginResult) {
            return ResponseUtils.getFailure("登陆失败");
        }
        return ResponseUtils.getSuccess("登陆成功");
    }

}
