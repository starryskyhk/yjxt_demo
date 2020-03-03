package com.wnsf.yjxt.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author jack
 * @since 2020-03-03
 */
public class Score implements Serializable {

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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
    public BigDecimal getGrdit() {
        return grdit;
    }

    public void setGrdit(BigDecimal grdit) {
        this.grdit = grdit;
    }
    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
    public String getStartSemester() {
        return startSemester;
    }

    public void setStartSemester(String startSemester) {
        this.startSemester = startSemester;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Score{" +
            "sourceId=" + sourceId +
            ", grdit=" + grdit +
            ", startYear=" + startYear +
            ", startSemester=" + startSemester +
            ", status=" + status +
            ", courseId=" + courseId +
            ", userId=" + userId +
        "}";
    }
}
