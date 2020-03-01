package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 学院名称
     */
    private Integer collegeId;

    /**
     * 专业名称
     */
    private Integer majorId;

    /**
     * 入学年度
     */
    private Integer year;


}
