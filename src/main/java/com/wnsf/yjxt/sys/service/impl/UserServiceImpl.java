package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wnsf.yjxt.sys.entity.StudentInfo;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.mapper.UserMapper;
import com.wnsf.yjxt.sys.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<StudentInfo> getStudentInfo() {
        return this.getStudentInfo(Wrappers.emptyWrapper());
    }

    @Override
    public List<StudentInfo> getStudentInfo(@Param(Constants.WRAPPER) Wrapper wrapper) {
        return userMapper.selectStudentInfo(wrapper);
    }
}
