package cn.sus.edu.partymemberdevelopment.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 功能描述: 用户实体类
 * @Author: 15735400536
 * @Date: 2020/8/17 15:13
 */
@Data
public class User {

    private Long userId;

    private String username;

    private String password;

    private String userSex;

    private Integer userAge;

    private String phoneNumber;

    private String mail;

    /**
     * 一级用户角色
     */
    private String firstLevelRole;

    /**
     * 注册时间
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
