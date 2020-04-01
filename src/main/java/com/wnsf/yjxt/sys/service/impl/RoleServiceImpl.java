package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.common.model.TreeNode;
import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.RoleResource;
import com.wnsf.yjxt.sys.mapper.RoleMapper;
import com.wnsf.yjxt.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色表
 服务实现类
 * </p>
 *
 * @author 陈泽
 * @since 2020-03-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private UseRoleServiceImpl useRoleService;
    @Autowired
    private  RoleResourceServiceImpl roleResourceService;
    @Autowired
    private RoleMapper roleMapper;
    /**
    * @Description: 删除角色
    * @Param: [id]
    * @return: boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        //删除user_role中的已经分配的
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("role_id",id);
        useRoleService.remove(queryWrapper);
        //删除role_resource
        roleResourceService.remove(queryWrapper);
        //删除role表
        super.removeById(id);

        return true;
    }
    /**
    * @Description: 得到资源列表
    * @Param: []
    * @return: java.util.List<com.wnsf.yjxt.sys.entity.RoleResource>
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    public List<RoleResource> getResource() {
        List<RoleResource> resource = roleMapper.getResource(null);
        //删除根结点
        resource.remove(resource.get(0));
        return resource;
    }
    /**
    * @Description: 角色列表
    * @Param: [id]
    * @return: java.util.List<com.wnsf.yjxt.sys.entity.RoleResource>
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    public List<RoleResource> getResource(Integer id) {
        List<RoleResource> resource = roleMapper.getResource(id);
        //删除根结点
        resource.remove(resource.get(0));
        for (RoleResource roleResource : resource) {
            if(roleResource.getRoleId()!=null){
                roleResource.setChecked(true);
            }else{
                roleResource.setChecked(false);
            }
        }
        return resource;
    }

    /**
    * @Description: 保存角色及其拥有的资源
    * @Param: [role, resourceIds]
    * @return: java.lang.Boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    @Transactional
    public Boolean addRole(Role role, String[] resourceIds) {
        //保存主键回显
        super.save(role);
        //添加资源
        List<RoleResource> list =new ArrayList<>();
        list.add(new RoleResource().setResourceId(1).setRoleId(role.getRoleId()));
        if (resourceIds==null){
            return true;
        }
        for (String rule :resourceIds ) {
            RoleResource roleResource=new RoleResource();
            roleResource.setRoleId(role.getRoleId()).setResourceId(Integer.parseInt(rule));
            list.add(roleResource);
        }
        roleResourceService.saveBatch(list);
        return true;
    }
    /**
    * @Description: 修改用户，和资源
    * @Param: [role, resourceIds]
    * @return: java.lang.Boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    @Transactional
    public Boolean updateRole(Role role, String[] resourceIds) {
        //先保存
        super.updateById(role);


        //先删除已有的
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("role_id",role.getRoleId());
        roleResourceService.remove(queryWrapper);
        //后添加
        List<RoleResource> list =new ArrayList<>();
        //list.add(new RoleResource().setResourceId(1).setRoleId(role.getRoleId()));
        if (resourceIds==null){
            return true;
        }
        for (String rule :resourceIds ) {
            RoleResource roleResource=new RoleResource();
            roleResource.setRoleId(role.getRoleId()).setResourceId(Integer.parseInt(rule));
            list.add(roleResource);
        }
        roleResourceService.saveBatch(list);
        return true;
    }


}
