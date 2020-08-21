package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.UserRole;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Api(tags = "用户角色接口文档")
@RequestMapping(value = "/role")
@RestController
public class UserRoleController {

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public Map<String, Object> addRole(@RequestBody UserRole userRole) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public Map<String, Object> deleteRole(@RequestParam("roleId") Long roleId) throws RuntimeException {
        return null;
    }

    @RequestMapping(value = "/modifyRole", method = RequestMethod.POST)
    public Map<String, Object> modifyRole(@RequestBody UserRole userRole) throws RuntimeException {
        return null;
    }

}
