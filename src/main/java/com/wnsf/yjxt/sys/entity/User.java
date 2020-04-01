package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学号/工号
     */
    @TableId(value = "user_id",type = IdType.INPUT)
    private Integer userId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 性别，1为男，2为女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 创建时间
     */

    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更改时间
     */

    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 学院id,为空则为超级管理员的
     */
    private Integer collegeId;
    private Integer majorId;
    private Integer classId;
    @TableField(exist = false)
    private String collegeName;
    @TableField(exist = false)
    private String majorName;
    @TableField(exist = false)
    private String className;
    @TableField(exist = false)
    private String year;
    @TableField(exist = false)
    private String type;
    @TableField(exist = false)
    private String roleId;
    @TableField(exist = false)
    private String name;
}
