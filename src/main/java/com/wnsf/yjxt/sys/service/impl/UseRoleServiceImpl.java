package com.wnsf.yjxt.sys.service.impl;

import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.UseRole;
import com.wnsf.yjxt.sys.mapper.UseRoleMapper;
import com.wnsf.yjxt.sys.service.IUseRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色表
描述用户和角色之间的关系 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Service
public class UseRoleServiceImpl extends ServiceImpl<UseRoleMapper, UseRole> implements IUseRoleService {
    @Autowired
    private UseRoleMapper useRoleMapper;
    @Override
    public List<UseRole> getUserHasRoleList(Integer userId) {
        return useRoleMapper.getUserHasRoleList(userId);
    }

}
