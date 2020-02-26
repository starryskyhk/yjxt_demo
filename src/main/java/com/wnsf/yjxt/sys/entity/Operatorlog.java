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
 * 操作日志表
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_operatorlog")
public class Operatorlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ol_id", type = IdType.AUTO)
    private Integer olId;

    /**
     * 操作类型，1添加，2删除，3修改，4查询
     */
    private Integer type;

    /**
     * 操作的内容
     */
    private String context;

    private LocalDateTime createTime;

    /**
     * 用户信息
     */
    private Integer userId;

    /**
     * 操作的资源
     */
    private Integer resourceId;


}
