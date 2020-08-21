package cn.sus.edu.partymemberdevelopment.service;

import cn.sus.edu.partymemberdevelopment.entity.ApplyRecord;

import java.util.Map;

public interface ApplyRecordService {

    int addApplyRecord(ApplyRecord applyRecord) throws RuntimeException;

    int delApplyRecord(Long recordId) throws RuntimeException;

    int modifyApplyRecord(ApplyRecord applyRecord) throws RuntimeException;

    ApplyRecord findOneByCondition(ApplyRecord applyRecord) throws RuntimeException;

    Map<String, Object> findAllByCondition(Map<String, Object> params) throws RuntimeException;


    /**
     * 功能描述: 提交党支部同入党申请人谈话记录
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 19:23
     */
    int submitPartyBranchCharHistory(ApplyRecord applyRecord) throws RuntimeException;


    /**
     * 功能描述: 修改党支部同入党申请人谈话记录状态
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 19:25
     */
    int modifyPartyBranchCharHistory(ApplyRecord applyRecord) throws RuntimeException;


    Map<String, Object> findAllPartyBranchCharHistory(Map<String, Object> params) throws RuntimeException;


    /**
     * 功能描述: 提交团组织优推表
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:21
     */
    int applyOrganizationRecommend(ApplyRecord applyRecord) throws RuntimeException;

    /**
     * 功能描述: 修改团组织优推记录
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:21
     */
    int modifyOrganizationRecommend(ApplyRecord applyRecord) throws RuntimeException;

    /**
     * 功能描述: 分页 多条件 查询团组织优推表
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 21:16
     */
    Map<String, Object> findAllOrganizationRecommend(Map<String, Object> params) throws RuntimeException;

    /**
     * 功能描述: 申请入党积极分子党员群众推荐表
     * @Param: []
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:23
     */
    int applyPartyMemberRecommend(ApplyRecord applyRecord) throws RuntimeException;


    /**
     * 功能描述: 修改入党积极分子党员群众推荐记录状态
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 18:24
     */
    int modifyPartyMemberRecommend(ApplyRecord applyRecord) throws RuntimeException;


    /**
     * 功能描述: 添加入党积极分子会议记录
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 20:31
     */
    int addPartyActivistsMeetingMinutes(ApplyRecord applyRecord) throws RuntimeException;

    /**
     * 功能描述: 查询如入党积极分子会议记录
     * @Param: [params]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: 15735400536
     * @Date: 2020/8/16 20:34
     */
    Map<String, Object> findAllPartyActivistsMeetingMinutes(Map<String, Object> params) throws RuntimeException;


    /**
     * 功能描述: 思想汇报(入党积极分子思想汇报)
     * @Param:
     * @Return:
     * @Author: 15735400536
     * @Date: 2020/8/16 19:05
     */
    int submitThoughtReport(ApplyRecord applyRecord) throws RuntimeException;

    /**
     * 功能描述: 修改思想汇报状态(3.9入党积极分子思想汇报)
     * @Param: [applyRecord]
     * @Return: int
     * @Author: 15735400536
     * @Date: 2020/8/16 19:11
     */
    int modifyThoughtReport(ApplyRecord applyRecord) throws RuntimeException;

}
