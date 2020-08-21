package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.PartyBranchCharHistory;
import cn.sus.edu.partymemberdevelopment.service.Impl.PartyBranchCharHistoryServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能描述:  党支部派人同入党申请人谈话记录Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 16:29
 */
@Api(tags = "党支部派人同入党申请人谈话记录文档")
@RequestMapping(value = "/partyBranch")
@RestController
public class PartyBranchCharHistoryController {

    @Autowired
    private PartyBranchCharHistoryServiceImpl charHistoryService;

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Map<String, Object> applyOrganizationRecommend(@RequestBody PartyBranchCharHistory charHistory) throws RuntimeException {
        int addResult = charHistoryService.addOne(charHistory);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Map<String, Object> modify(@RequestBody PartyBranchCharHistory charHistory) throws RuntimeException {
        int modifyResult = charHistoryService.modifyOne(charHistory);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map<String, Object> find(Map<String, Object> params) throws RuntimeException {
        return charHistoryService.findAll(params);
    }


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
