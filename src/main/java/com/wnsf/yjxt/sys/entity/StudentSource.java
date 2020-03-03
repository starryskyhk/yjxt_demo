package com.wnsf.yjxt.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 韩坤
 * @create 2020-03-02-20:36
 * 学生挂科成绩类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentSource {
    /**
     * 课程开设学院名称
     */
    private String collegeName;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程学分
     */
    private String credit;
    /**
     * 课程开设学年
     */
    private String startYear;
    /**
     * 课程开设学期
     */
    private String startSemester;
    /**
     * 课程成绩
     */
    private double grdit;
}
