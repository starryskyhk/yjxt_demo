package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程学分
     */
    private Integer credit;

    /**
     * 开设学院Id
     */
    private Integer collegeId;


}
