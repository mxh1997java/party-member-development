package cn.sus.edu.partymemberdevelopment.controller;


import cn.sus.edu.partymemberdevelopment.entity.PartyMemberRecommend;
import cn.sus.edu.partymemberdevelopment.service.Impl.PartyMemberRecommendServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 功能描述:  入党积极分子党员群众推荐表业务层Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 17:41
 */
@Api(tags = "入党积极分子党员群众推荐表业务层")
@RequestMapping(value = "/partyMember")
@RestController
public class PartyMemberRecommendController {

    @Autowired
    private PartyMemberRecommendServiceImpl recommendService;

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Map<String, Object> applyOrganizationRecommend(@RequestBody PartyMemberRecommend recommend) throws RuntimeException {
        int addResult = recommendService.addOne(recommend);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Map<String, Object> modify(@RequestBody PartyMemberRecommend recommend) throws RuntimeException {
        int modifyResult = recommendService.modifyOne(recommend);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map<String, Object> find(Map<String, Object> params) throws RuntimeException {
        return recommendService.findAll(params);
    }


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
