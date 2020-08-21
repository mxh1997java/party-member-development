package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述:  预备党员一封信
 * @Author: 15735400536
 * @Date: 2020/8/18 13:31
 */
@Data
public class PreparationMemberLetter {

    private Long recordId;

    /**
     * 记录名称
     */
    private String recordName;

    /**
     * 会议记录文件
     */
    private String recordFileUrl;

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
