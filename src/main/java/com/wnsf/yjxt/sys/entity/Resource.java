package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源Id
     */
    @TableId(value = "resource_id", type = IdType.AUTO)
    private Integer resourceId;

    /**
     * 父资源id
     */
    private Integer parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源树路径
     */
    private String path;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 授权（用,隔开）
     */
    private String permission;

    /**
     * 资源类型（-1根目录，0目录，1菜单，2按钮）
     */
    private String type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
    * @Description: 状态
    * @Param:
    * @return:
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    private Integer status = 0;
    @TableField(exist = false)
    private Integer roleId;


}
