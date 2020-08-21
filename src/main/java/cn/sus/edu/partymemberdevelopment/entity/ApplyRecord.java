package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 入党申请记录
 * @Author: XinHai.Ma
 * @Date: 2020/8/16 11:17
 */
@Data
public class ApplyRecord {

    //申请id
    private Long applyId;

    //申请人
    private String applicant;

    //申请人Id
    private Long applicantId;

    //入党申请书地址
    private String fileUrl;

    //申请时间
    private LocalDateTime createTime;

    //申请状态
    private Integer applyStatus;

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
