package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wnsf.yjxt.sys.entity.Score;
import com.wnsf.yjxt.sys.entity.StudentScore;
import com.wnsf.yjxt.sys.mapper.ScoreMapper;
import com.wnsf.yjxt.sys.service.IScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author jack
 * @since 2020-03-03
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public Page<StudentScore> getStudentScore(Page<StudentScore> page, @Param("ew") Wrapper wrapper) {
        return scoreMapper.selectStudentScore(page,wrapper);
    }
}
