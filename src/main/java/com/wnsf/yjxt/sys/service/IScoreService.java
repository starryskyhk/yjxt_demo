package com.wnsf.yjxt.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wnsf.yjxt.sys.entity.Score;
import com.wnsf.yjxt.sys.entity.StudentScore;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author jack
 * @since 2020-03-03
 */
public interface IScoreService extends IService<Score> {
    /***
     * 根据条件查询成绩信息
     * @Author 韩坤
     * @Date  2020/3/3
     * @param page	分页对象
     * @param wrapper	条件
     * @return
     */
    public Page<StudentScore> getStudentScore(Page<StudentScore> page,@Param("ew") Wrapper wrapper);
}
