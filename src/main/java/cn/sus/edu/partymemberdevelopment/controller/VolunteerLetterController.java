package cn.sus.edu.partymemberdevelopment.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 类描述: 入党志愿书Controller
 * @Author: 15735400536
 * @Date: 2020/8/16 21:33
 */
@Api(tags = "入党志愿书接口文档")
@RequestMapping("/volunteerLetter")
@RestController
public class VolunteerLetterController {

    /**
     * 功能描述: 上传入党志愿书
     * @Param: [file]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 21:38
     */
    @RequestMapping(value = "/uploadLetter", method = RequestMethod.POST)
    public Map<String, Object> uploadLetter(@RequestParam("file") MultipartFile file) throws RuntimeException {
        return null;
    }

    /**
     * 功能描述: 查询入党志愿书上传记录
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 21:39
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
