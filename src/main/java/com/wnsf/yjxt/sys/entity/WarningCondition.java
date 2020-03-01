package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 预警条件表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarningCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 一学期挂科数目
     */
    private Integer semester;

    /**
     * 学年挂科数目
     */
    private Integer academicYear;

    private Integer total;

    /**
     * 预警类型，1学业预警，2留级预警，3退学预警
     */
    private Integer type;

    /**
     * 各学院的设置的条件，为空则为统一标准
     */
    private Integer collegeId;


}
