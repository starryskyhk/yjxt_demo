package com.wnsf.yjxt.sys.service;

import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.common.model.TreeNode;
import com.wnsf.yjxt.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wnsf.yjxt.sys.entity.RoleResource;

import java.util.List;

/**
 * <p>
 * 角色表
 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface IRoleService extends IService<Role> {
    /**
     * 添加用户时初始化资源列表
     * @return
     */
    List<RoleResource> getResource();
    /**
     * 获取角色已经拥有的资源
     * @param id
     * @return
     */
    List<RoleResource> getResource(Integer id);


    Boolean addRole(Role role,String[] resourceIds);

    Boolean updateRole(Role role,String[] resourceIds);




}
