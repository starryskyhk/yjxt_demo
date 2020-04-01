package com.wnsf.yjxt.sys.service;

import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.UseRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色表
描述用户和角色之间的关系 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface IUseRoleService extends IService<UseRole> {
    /**
     * 获取用户拥有的角色
     * @param userId
     * @return
     */
    List<UseRole> getUserHasRoleList(Integer userId);


}
