package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wnsf.yjxt.sys.entity.StudentSource;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.mapper.UserMapper;
import com.wnsf.yjxt.sys.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    //根据条件查询User对象
    public Page<User> getStudentInfo(Page<User> page, @Param("ew") Wrapper wrapper) {
        return userMapper.selectStudentInfo(page,wrapper) ;
    }
    //根据条件查询学生的挂科情况
    @Override
    public Page<StudentSource> getStudentSource(Page<StudentSource> page, Wrapper wrapper) {
        return userMapper.selectStudentSource(page,wrapper);
    }
}
