package cn.sus.edu.partymemberdevelopment.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能描述: 批准入党通知书Controller
 * @Author: 15735400536
 * @Date: 2020/8/16 21:44
 */
@Api(tags = "批准入党通知书接口文档")
@RequestMapping("/approval")
@RestController
public class ApprovalJoinPartyNoticeController {


    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map<String, Object> submit(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public Map<String, Object> findAll(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
