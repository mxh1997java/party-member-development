package cn.sus.edu.partymemberdevelopment.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 功能描述: 中共预备党员票决情况汇总表Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 10:57
 */
@Api(tags = "中共预备党员票决情况汇总表接口文档")
@RequestMapping(value = "/voteSummary")
@RestController
public class VoteSummaryTableController {

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
