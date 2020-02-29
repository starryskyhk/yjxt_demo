package com.wnsf.yjxt.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 韩坤
 * @create 2020-02-29-19:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentInfo {
    private static final long serialVersionUID = 1L;
    /**
     * 学院名称
     */
    private String collegeName;
    /**
     * 专业名称
     */
    private String majorName;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 学生所在年级
     */
    private String year;
    /**
     * 学生学号
     */
    private String userId;
    /**
     * 学生姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 预警类型
     */
    private String type;

}
