package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 党支部派人同入党申请人谈话记录
 * @Author: 15735400536
 * @Date: 2020/8/18 13:59
 */
@Data
public class PartyBranchCharHistory {

    private Long recordId;

    /**
     * 功能描述: 党支部名称
     */
    private String partyBranchName;


    /**
     * 功能描述: 申请人名称
     */
    private String applicantName;


    /**
     * 功能描述: 性别
     */
    private String sex;


    /**
     * 功能描述: 民族
     */
    private String nation;


    /**
     * 功能描述: 籍贯
     */
    private String hometown;

    /**
     * 功能描述: 所属单位/部门
     */
    private String department;

    /**
     * 功能描述: 学号/工号
     */
    private String wordId;

    /**
     * 功能描述: 出生日期
     */
    private LocalDateTime birthDate;


    /**
     * 功能描述: 入团日期
     */
    private LocalDateTime joinGroupDate;


    /**
     * 功能描述: 申请入党日期
     */
    private LocalDateTime applyJoinPartyDate;

    /**
     * 功能描述: 谈话时间
     */
    private LocalDateTime talkTime;

    /**
     * 功能描述: 谈话地点
     */
    private String talkLocation;


    /**
     * 功能描述: 谈话记录
     */
    private String talkRecord;

    /**
     * 功能描述: 谈话人
     */
    private String talker;

    /**
     * 功能描述: 所在单位及职务
     */
    private String unitPosition;

    /**
     * 功能描述: 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 功能描述: 创建者
     */
    private String creator;

    /**
     * 功能描述: 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 功能描述: 修改者
     */
    private String modifier;

}
