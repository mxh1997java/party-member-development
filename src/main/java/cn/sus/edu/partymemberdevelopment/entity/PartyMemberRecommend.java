package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述:  功能描述: 申请入党积极分子党员群众推荐表
 * @Author: 15735400536
 * @Date: 2020/8/18 16:49
 */
@Data
public class PartyMemberRecommend {

    private Long recordId;

    /**
     * 姓名
     */
    private String applicant;

    /**
     * 性别
     */
    private String sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 学号/工号
     */
    private String studentId;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 现任职务/身份
     */
    private String currentPosition;

    /**
     * 出生日期
     */
    private LocalDateTime birthDate;

    /**
     * 申请入党日期
     */
    private LocalDateTime applyJoinPartyDate;

    /**
     * 主要表现
     */
    private String mainPerformance;

    /**
     * 主要奖惩情况
     */
    private String mainRewardsPunishments;


    /**
     * 党员群众推荐情况
     */
    private String recommendedSituation;

    /**
     * 党支部名称
     */
    private String partyBranchName;

    /**
     * 党支部书记签名
     */
    private String partyBranchSecretarySignature;

    /**
     * 签名时间
     */
    private LocalDateTime signatureTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 创建者
     */
    private String creator;
}
