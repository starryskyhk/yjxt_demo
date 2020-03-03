package com.wnsf.yjxt.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wnsf.yjxt.sys.entity.Score;
import com.wnsf.yjxt.sys.entity.StudentScore;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 成绩表 Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2020-03-03
 */
public interface ScoreMapper extends BaseMapper<Score> {
    /***
     * 根据条件查询学生成绩
     * @Author 韩坤
     * @Date  2020/3/3
     * @param page
     * @param wrapper
     * @return
     */
    Page<StudentScore> selectStudentScore(Page<StudentScore> page, @Param("ew") Wrapper wrapper);
}
