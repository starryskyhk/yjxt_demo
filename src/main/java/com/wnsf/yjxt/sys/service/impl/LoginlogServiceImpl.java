package com.wnsf.yjxt.sys.service.impl;

import com.wnsf.yjxt.sys.entity.Loginlog;
import com.wnsf.yjxt.sys.mapper.LoginlogMapper;
import com.wnsf.yjxt.sys.service.ILoginlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Service
public class LoginlogServiceImpl extends ServiceImpl<LoginlogMapper, Loginlog> implements ILoginlogService {

}
