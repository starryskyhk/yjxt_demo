package com.wnsf.yjxt.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface IUserService extends IService<User> {
    /**
     *  根据条件查询User对象列表
     * @Author 韩坤
     * @Date  2020/3/1
     * @param page	分页对象
     * @param wrapper	条件构造器
     * @return 返回Page对象
     */
    public Page<User> getStudentInfo(Page<User> page,@Param("ew") Wrapper wrapper);

    /***
     * 根据学号查询学生信息
     * @Author 韩坤
     * @Date  2020/3/3
     * @param userId
     * @return
     */
    User getStudentInfoById(String userId);

    /**
     * 获取所有管理员的信息
     * @return
     */
    List<User> getAdminList();

    /**
     * 删除管理员信息
     * @param userId
     * @return
     */
    Boolean removeByAdminId(Integer userId);

    /**
     * 获取一个管理员的信息
     * @param id
     * @return
     */
    User getAdminById(Integer id);

    /**
     * select2初始化
     * @param id
     * @return
     */
    List<Select2> select2List(Integer id);

    Boolean savaUserAndRoleids(User user,String[] roleds);

    Boolean updateUserAndRoleids(User user,String[] roleds);

    Boolean resetUserPassword(Integer userId);


}
