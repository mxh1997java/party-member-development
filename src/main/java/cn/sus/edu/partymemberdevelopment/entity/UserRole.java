package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 用户角色表
 * @Author: 15735400536
 * @Date: 2020/8/17 15:25
 */
@Data
public class UserRole {

    private Long roleId;

    private String roleName;

    /**
     * 角色对应的访问路径
     */
    private String url;

    /**
     * 角色对应的申请记录查看状态
     */
    private Integer code;

    /**
     * 角色描述
     */
    private String description;

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
