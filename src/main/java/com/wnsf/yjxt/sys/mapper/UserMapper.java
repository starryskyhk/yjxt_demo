package com.wnsf.yjxt.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wnsf.yjxt.sys.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     *  根据条件查询User对象
     * @Author 韩坤
     * @Date  2020/3/1
     * @param page	分页对象
     * @param wrapper	条件构造器
     * @return 返回Page对象
     */
    Page<User> selectStudentInfo(Page<User> page, @Param("ew") Wrapper wrapper);
}
