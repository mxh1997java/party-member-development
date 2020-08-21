package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.ExcellentRecommend;
import cn.sus.edu.partymemberdevelopment.service.Impl.ExcellentRecommendServiceImpl;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 功能描述: 团组织优推表Controller
 * @Author: 15735400536
 * @Date: 2020/8/18 10:12
 */
@Api(tags = "团组织优推表接口文档")
@RequestMapping(value = "excellentRecommend")
@RestController
public class ExcellentRecommendController {

    @Autowired
    private ExcellentRecommendServiceImpl excellentRecommendService;

    /**
     * 功能描述: 申请团组织推优
     * @Param:
     * @Return:
     * @Author: 15735400536
     * @Date: 2020/8/16 18:09
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public Map<String, Object> applyOrganizationRecommend(@RequestBody ExcellentRecommend recommend) throws RuntimeException {
        int addResult = excellentRecommendService.addOne(recommend);
        if(addResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Map<String, Object> modify(@RequestBody ExcellentRecommend recommend) throws RuntimeException {
        int modifyResult = excellentRecommendService.modifyOne(recommend);
        if(modifyResult < 1) {
            return ResponseUtils.getFailure("添加失败");
        }
        return ResponseUtils.getSuccess("添加成功");
    }


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map<String, Object> find(Map<String, Object> params) throws RuntimeException {
        return excellentRecommendService.findAll(params);
    }


    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public Map<String, Object> export(Map<String, Object> params) throws RuntimeException {
        return null;
    }

}
