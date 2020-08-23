package cn.sus.edu.partymemberdevelopment.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 功能描述: 接收预备党员表决票Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 11:01
 */
@Api(tags = "接收预备党员表决票接口文档")
@RequestMapping(value = "/vote", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class VoteController {


//    在Spring MVC中，两者的作用都是将request里的参数的值绑定到controller里的方法参数里的，区别在于，URL写法不同。
//    使用@RequestParam时，URL是这样的: http://host:port/path?参数名=参数值
//    使用@PathVariable时，URL是这样的: http://host:port/path/参数值


     /**
     * 功能描述: POST用来创建资源
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/23 22:33
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Map<String, Object> create(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: GET用来获取资源
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/23 22:33
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Map<String, Object> query(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: PUT用来修改资源
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/23 22:34
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Map<String, Object> update(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: DELETE用来删除资源
     * @Param: [recordId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/23 22:34
     */
    @RequestMapping(value = "/delete/{recordId}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Long recordId) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
