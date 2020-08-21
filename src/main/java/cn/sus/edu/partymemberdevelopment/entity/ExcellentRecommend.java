package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 团组织优推表
 * @Author: 15735400536
 * @Date: 2020/8/18 13:28
 */
@Data
public class ExcellentRecommend {

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
     * 学号
     */
    private String studentId;

    /**
     * 所在班级
     */
    private String className;

    /**
     * 现任职务/身份
     */
    private String currentPosition;

    /**
     * 出生日期
     */
    private LocalDateTime birthDate;

    /**
     * 入团日期
     */
    private LocalDateTime joinGroupDate;


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

    //========== 团支部推荐意见start ==========
    /**
     * 年
     */
    private Integer yearValue;

    /**
     * 月
     */
    private Integer monthValue;

    /**
     * 日
     */
    private Integer dayValue;

    /**
     * 同志
     */
    private String comrade;

    /**
     * 团支部名称
     */
    private String leagueBranchName;

    /**
     * 团支部书记签名
     */
    private String leagueSecretary;


    /**
     * 团支部书记签名时间
     */
    private LocalDateTime signatureTime;


    /**
     * 应到会人数
     */
    private Integer participateNum;

    /**
     * 实到会人数
     */
    private Integer arrivalsNum;

    /**
     * 赞成票数
     */
    private Integer agreeNum;

    /**
     * 反对票数
     */
    private Integer opposeNum;
    /**
     * 有效票数
     */
    private Integer effectiveNum;

    /**
     * 弃权票数
     */
    private Integer invalidNum;

    //========== 团支部推荐意见end ==========

    /**
     * 学院团委审核意见
     */
    private String reviewOpinion;

    /**
     * 学院团委审核意见签名
     */
    private String reviewOpinionSignature;

    /**
     * 学院团委审核意见签名时间
     */
    private LocalDateTime reviewOpinionSignatureTime;

    /**
     * 校团委备案意见
     */
    private String recordOpinion;

    /**
     * 校团委盖章
     */
    private String schoolLeagueCommitteeSeal;

    /**
     * 团委书记签章
     */
    private String secretarySignature;

    /**
     * 校团委签章时间
     */
    private LocalDateTime recordOpinionSignatureTime;

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
