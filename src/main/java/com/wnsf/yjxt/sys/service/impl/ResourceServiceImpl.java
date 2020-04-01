package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wnsf.yjxt.common.model.TreeNode;
import com.wnsf.yjxt.common.util.TreeUtil;
import com.wnsf.yjxt.sys.entity.Resource;
import com.wnsf.yjxt.sys.mapper.ResourceMapper;
import com.wnsf.yjxt.sys.mapper.RoleMapper;
import com.wnsf.yjxt.sys.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
    @Autowired
    private RoleResourceServiceImpl roleResourceService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;
    /**
    * @Description: 删除
    * @Param: [id]
    * @return: boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    @Transactional
    public boolean removeById(Serializable id) {

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("resource_id",id);
        roleResourceService.remove(queryWrapper);
        super.removeById(id);
        return true;
    }
    /**
     * 更加id获取名字
     * @param id
     * @return
     */
    public String getNameByResourceId(Integer id){
        return roleMapper.getName(id);
    }

    /**
     * 重写sava设置path
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public boolean save(Resource entity) {
        //先保存,保存之后会自动将主键回显到entity
        super.save(entity);

        //获取父资源的路径
        Resource parent=this.getById(entity.getParentId());
        //生成新的路径
        String path=parent.getPath()+"-"+entity.getResourceId();
        entity.setPath(path);
        this.updateById(entity);
        //在设置
        return true;
    }
    /**
    * @Description:      这个现在还没用上
    * @Param: [id]
    * @return: com.wnsf.yjxt.common.model.TreeNode
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    public TreeNode getTreeById(Integer id) {
        Resource r = this.getById(id);
        //1.查询该节点下所有节点
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("path",r.getPath());
        queryWrapper.orderByAsc("order_num");
        List<Resource> list = this.list(queryWrapper);

        //2.对象数据转换
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Resource resource : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(resource.getResourceId());
            treeNode.setName(resource.getName());
            treeNode.setParentId(resource.getParentId());
            treeNode.setPath(resource.getPath());
            treeNodeList.add(treeNode);
        }
        TreeUtil treeUtil = new TreeUtil(treeNodeList);
        TreeNode treeNode = treeUtil.generateTree(id);
        return treeNode;
    }

    /**
     * 获取角色拥有的资源
     * @param id
     * @return
     */
    @Override
    public TreeNode getRoleResource(Integer id) {
        //获取角色拥有的权限
        List<Resource> roleResource = resourceMapper.getRoleResource(id);

        //对象数据转换
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Resource resource : roleResource) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(resource.getResourceId());
            treeNode.setName(resource.getName());
            treeNode.setParentId(resource.getParentId());
            treeNode.setPath(resource.getPath());
            if (resource.getRoleId()==null){
                treeNode.setState(false);
            }else{
                treeNode.setState(true);
            }
            treeNodeList.add(treeNode);
        }
        //生成树
        TreeUtil treeUtil = new TreeUtil(treeNodeList);
        TreeNode treeNode = treeUtil.generateTree(1);
        return treeNode;
    }





}
