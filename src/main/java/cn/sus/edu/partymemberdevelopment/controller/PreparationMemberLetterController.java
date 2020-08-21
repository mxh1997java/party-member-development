package cn.sus.edu.partymemberdevelopment.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * 功能描述: 预备党员一封信Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 10:06
 */
@Api(tags = "预备党员一封信接口文档")
@RequestMapping("/preparation")
@RestController
public class PreparationMemberLetterController {


    /**
     * 功能描述: 提交预备党员一封信
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/18 10:27
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map<String, Object> submitLetter(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 查看预备党员一封信
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/18 10:40
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map<String, Object> findLetter(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 导出预备党员一封信
     * @Param: [request, response]
     * @Return: void
     * @Author: 15735400536
     * @Date: 2020/8/18 10:40
     */
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public void exportLetter(HttpServletRequest request, HttpServletResponse response) throws RuntimeException {

    }


}