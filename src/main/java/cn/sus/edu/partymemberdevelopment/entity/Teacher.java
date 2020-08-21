package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 老师实体类
 * @Author: 15735400536
 * @Date: 2020/8/17 15:04
 */
@Data
public class Teacher {

    private Long userId;

    private Long teacherId;

    private String teacherName;

    /**
     * 学院党支部书记
     */
    private String collegePartyBranchSecretary;

    /**
     * 辅导员
     */
    private String counselor;

    /**
     * 学院党委组织员
     */
    private String collegePartyCommitteeOrganizer;

    /**
     * 学院党总支组织员
     */
    private String collegePartyTotalBranchOrganizer;

    /**
     * 学院直属党支组织员
     */
    private String collegeDirectlyUnderPartyBranchOrganizer;

    /**
     * 学院团委
     */
    private String collegeYouthLeagueCommittee;

    /**
     * 学校团委
     */
    private String schoolYouthLeagueCommittee;

    /**
     * 党委组织部
     */
    private String partyCommitteeOrganizationDepartment;

    /**
     * 学院党委书记
     */
    private String collegePartySecretary;

    /**
     * 学院党委副书记
     */
    private String collegePartyCommitteeViceSecretary;

    /**
     * 学院党总支书记
     */
    private String collegePartyTotalBranchSecretary;

    /**
     * 学院党总支副书记
     */
    private String collegePartyTotalBranchViceSecretary;

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
