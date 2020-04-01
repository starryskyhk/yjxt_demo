package com.wnsf.yjxt.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wnsf.yjxt.common.model.TreeNode;
import com.wnsf.yjxt.sys.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wnsf.yjxt.sys.entity.RoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface IResourceService extends IService<Resource> {
    /**
     * 通过资源id获取名字
     * @param id
     * @return
     */
    String getNameByResourceId(Integer id);
    /**
     * 通过节点id查询该节点和所有子节点组成的树形结构数据
     *
     * @param
     * @return
     */
    TreeNode getTreeById(Integer id);

    /**
     * 获取角色拥有的资源
     * @param id
     * @return
     */
    TreeNode getRoleResource(Integer id);

}
