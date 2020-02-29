package com.wnsf.yjxt.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wnsf.yjxt.sys.entity.StudentInfo;
import com.wnsf.yjxt.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
public interface UserMapper extends BaseMapper<User> {

    List<StudentInfo> selectStudentInfo(Wrapper wrapper);
}
