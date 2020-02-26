package com.wnsf.yjxt.sys.service.impl;

import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.mapper.UserMapper;
import com.wnsf.yjxt.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
