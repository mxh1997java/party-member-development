package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 功能描述: 学生实体类
 * @Author: 15735400536
 * @Date: 2020/8/17 14:54
 */
@Data
public class Student {

    private Long studentId;

    private Long userId;

    private String studentName;

    /**
     * 籍贯
     */
    private String hometown;


    /**
     * 所属单位/部门职务
     */
    private String departmentPosition;


    /**
     * 学号/工号
     */
    private String jobNumber;

    /**
     * 出生日期
     */
    private LocalDate bornDate;


    /**
     * 入团日期
     */
    private LocalDateTime joinGroupDate;

    /**
     * 申请入党日期
     */
    private LocalDateTime applyJoinPartyDate;


    /**
     * 出生年月
     */
    private LocalDateTime birthday;


    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 参加工作年月
     */
    private LocalDateTime joinJobDate;


    /**
     * 本人简历
     */
    private String resume;


    /**
     * 家庭成员、主要社会关系情况
     */
    private String familyMember;


    /**
     * 入党日期/转正日期
     */
    private LocalDateTime joinPartyDate;

    /**
     * 所属支部
     */
    private String affiliatedBranch;


    /**
     * 党内职务
     * */
    private String partyPosition;

    private LocalDateTime createTime;

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
