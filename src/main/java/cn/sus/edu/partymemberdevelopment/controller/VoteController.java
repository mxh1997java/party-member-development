package cn.sus.edu.partymemberdevelopment.controller;

import io.swagger.annotations.Api;
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
@RequestMapping(value = "/vote")
@RestController
public class VoteController {

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map<String, Object> submit(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map<String, Object> find(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
