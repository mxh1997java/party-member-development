package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.entity.ApplyRecord;
import cn.sus.edu.partymemberdevelopment.service.Impl.ApplyRecordServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Api(tags = "入党申请接口文档")
@RequestMapping("/applyRecord")
@RestController
public class ApplyRecordController {

    @Autowired
    private ApplyRecordServiceImpl applyRecordService;

    /**
     * 功能描述: 查询单条入党申请记录
     * @Param: [applyRecord]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 17:24
     */
    @RequestMapping(value = "findOneByCondition", method = RequestMethod.GET)
    public Map<String, Object> findOneByCondition(@RequestBody ApplyRecord applyRecord) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 按条件查询 分页查询 多条记录
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 17:25
     */
    @RequestMapping(value = "findAllByCondition", method = RequestMethod.GET)
    public Map<String, Object> findAllByCondition(Map<String, Object> params) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 提交入党申请
     * @Param: [applyRecord]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 17:31
     */
    @RequestMapping(value = "addApplyRecord", method = RequestMethod.POST)
    public Map<String, Object> addApplyRecord(@RequestBody ApplyRecord applyRecord) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 修改入党申请
     * @Param: [applyRecord]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 17:31
     */
    @RequestMapping(value = "modifyApplyRecord", method = RequestMethod.POST)
    public Map<String, Object> modifyApplyRecord(@RequestBody ApplyRecord applyRecord) throws RuntimeException {
        return null;
    }


    /**
     * 功能描述: 修改入党申请
     * @Param: [recordId]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 17:31
     */
    @RequestMapping(value = "deleteApplyRecord", method = RequestMethod.POST)
    public Map<String, Object> deleteApplyRecord(@RequestParam("recordId") Long recordId) throws RuntimeException {
        return null;
    }

}
