package com.wnsf.yjxt.sys.mapper;

import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.UseRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户角色表
描述用户和角色之间的关系 Mapper 接口
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface UseRoleMapper extends BaseMapper<UseRole> {
    /**
     * 获取用户拥有的角色列表
     * @param userId
     * @return
     */
    List<UseRole> getUserHasRoleList(Integer userId);

}
