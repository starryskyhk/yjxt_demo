package com.wnsf.yjxt.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wnsf.yjxt.sys.entity.StudentInfo;
import com.wnsf.yjxt.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
public interface IUserService extends IService<User> {
    /**
     *查询学生信息,返回学生列表
     * @Author 韩坤
     * @Date  2020/2/29
     * @param
     * @return
     */
    public List<StudentInfo> getStudentInfo();
    /**
     * 根据条件查询学生信息，返回学生猎豹
     * @Author 韩坤
     * @Date  2020/2/29
     * @param wrapper
     * @return
     */
    public List<StudentInfo> getStudentInfo(@Param(Constants.WRAPPER) Wrapper wrapper);
}
