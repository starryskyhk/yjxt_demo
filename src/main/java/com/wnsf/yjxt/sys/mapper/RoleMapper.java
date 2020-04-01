package com.wnsf.yjxt.sys.mapper;

import com.wnsf.yjxt.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wnsf.yjxt.sys.entity.RoleResource;

import java.util.List;

/**
 * <p>
 * 角色表
 Mapper 接口
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据id获取名字
     * @param id
     * @return
     */
    String getName(Integer id);

    /**
     * 根据角色id获取拥有的资源
     * @param id
     * @return
     */
    List<RoleResource> getResource(Integer id);
}
