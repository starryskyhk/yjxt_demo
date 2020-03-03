package com.wnsf.yjxt.sys.service.impl;

import com.wnsf.yjxt.sys.entity.Resource;
import com.wnsf.yjxt.sys.mapper.ResourceMapper;
import com.wnsf.yjxt.sys.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

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


    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        this.removeById(id);
        roleResourceService.removeById(id);
        return true;
    }

    /**
     * 表单hui
     * @param entity
     * @return
     */
    @Override
    public boolean save(Resource entity) {
        String icon="<i class=\""+entity.getIcon()+"\"></i>";
        entity.setIcon(icon);
        super.save(entity);
        return true;
    }
}
