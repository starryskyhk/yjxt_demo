package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_loginlog")
public class Loginlog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志编号
     */
    @TableId(value = "ll_id", type = IdType.AUTO)
    private Integer llId;

    /**
     * 操作者id（用户Id）
     */
    private Integer userId;

    /**
     * 登录的时间
     */
    private LocalDateTime llTime;

    /**
     * 0失败，1成功
     */
    private Integer status;

    /**
     * 登录的ip地址
     */
    private String ip;


}
