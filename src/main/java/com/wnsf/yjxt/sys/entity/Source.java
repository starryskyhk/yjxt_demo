package com.wnsf.yjxt.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Source implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成绩表主键
     */
    @TableId(value = "source_id", type = IdType.AUTO)
    private Integer sourceId;

    /**
     * 成绩
     */
    private BigDecimal grdit;

    /**
     * 开课学年
     */
    private String startYear;

    /**
     * 开课学期
     */
    private String startSemester;

    /**
     * 状态，0正常，1缺考，2缓考，3重修
     */
    private Integer status;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 用户id
     */
    private Integer userId;


}
