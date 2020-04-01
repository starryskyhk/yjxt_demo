package com.wnsf.yjxt.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.common.util.MD5Util;
import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.UseRole;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.mapper.UserMapper;
import com.wnsf.yjxt.sys.service.IRoleService;
import com.wnsf.yjxt.sys.service.IUseRoleService;
import com.wnsf.yjxt.sys.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private IUseRoleService useRoleService;
    @Autowired
    private IRoleService roleService;

    @Override
    //根据条件查询User对象
    public Page<User> getStudentInfo(Page<User> page, @Param("ew") Wrapper wrapper) {
        return userMapper.selectStudentInfo(page, wrapper);
    }


    @Override
    public User getStudentInfoById(String userId) {
        return userMapper.selectStudentInfoById(userId);
    }

    /**
     * @Description: 获取管理员列表
     * @Param: []
     * @return: java.util.List<com.wnsf.yjxt.sys.entity.User>
     * @Author: 陈啧啧
     * @Date: 2020/4/1
     */
    @Override
    public List<User> getAdminList() {
        return userMapper.getAdminList();
    }

    /**
     * @Description: 删除管理员信息
     * @Param: [id]
     * @return: java.lang.Boolean
     * @Author: 陈啧啧
     * @Date: 2020/4/1
     */
    @Override
    @Transactional
    public Boolean removeByAdminId(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);
        //先删除role_user表
        useRoleService.remove(queryWrapper);
        //再删除user表
        this.remove(queryWrapper);
        return true;
    }

    /**
     * @Description: 获取管理员信息
     * @Param: [id]
     * @return: com.wnsf.yjxt.sys.entity.User
     * @Author: 陈啧啧
     * @Date: 2020/4/1
     */
    @Override
    public User getAdminById(Integer id) {
        return userMapper.getAdminById(id);
    }

    /**
     * @Description: 获取用户拥有的角色。初始化select2
     * @Param:
     * @return:
     * @Author: 陈啧啧
     * @Date: 2020/4/1
     */
    @Override
    public List<Select2> select2List(Integer id) {
        List<Role> list = new ArrayList<>();
        //id拥有的角色集合
        List<UseRole> userHasRoleList = useRoleService.getUserHasRoleList(id);
        //转化为select2需要的对象
        ArrayList<Select2> select2 = new ArrayList<>();
        //对象转换
        for (UseRole useRole : userHasRoleList) {
            Select2 select = new Select2();
            select.setId(useRole.getRoleId());
            select.setText(useRole.getName());
            if (useRole.getUserId() == null) {
                select.setSelected(false);
            } else {
                select.setSelected(true);
            }
            select2.add(select);
        }

        return select2;
    }

    /**
     * @Description: 保存角色
     * @Param: [user, roleds]
     * @return: java.lang.Boolean
     * @Author: 陈啧啧
     * @Date: 2020/3/31
     *
     */
    @Override
    @Transactional
    public Boolean savaUserAndRoleids(User user, String[] roleds) {
        //记得校验
        //私盐
        String salt = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        //加密后的密码
        String password = MD5Util.md5_private_salt(user.getUserId().toString(), salt);
        user.setPassword(password);
        user.setSalt(salt);
        super.save(user);
        //是否为空
        if (roleds==null){
            return true;
        }
        List<UseRole> useRoles=new ArrayList<>();
        //保存用户拥有的角色
        for (String roles : roleds) {
            UseRole useRole = new UseRole();
            useRole.setUserId(user.getUserId());
            useRole.setRoleId(Integer.parseInt(roles));
            useRoles.add(useRole);
        }
        useRoleService.saveBatch(useRoles);
        return true;
    }
    /**
    * @Description: 修改用户基本信息和
    * @Param: [user, roleds]
    * @return: java.lang.Boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    @Transactional
    public Boolean updateUserAndRoleids(User user, String[] roleds) {

        super.updateById(user);

        //如果修改后的角色数组为空，则说明该用户没有角色，清空
        if(roleds==null){
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("user_id",user.getUserId());
            useRoleService.remove(queryWrapper);
            return true;
        }
        List<UseRole> useRoles=new ArrayList<>();
        //保存用户拥有的角色
        for (String roles : roleds) {
            UseRole useRole = new UseRole();
            useRole.setUserId(user.getUserId());
            useRole.setRoleId(Integer.parseInt(roles));
            useRoles.add(useRole);
        }
        useRoleService.saveBatch(useRoles);
        return true;
    }

    /**
    * @Description: 重置用户密码
    * @Param: [userId]
    * @return: java.lang.Boolean
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @Override
    public Boolean resetUserPassword(Integer userId) {
        User user = super.getById(userId);
        //私盐
        String salt = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        //加密后的密码
        String password = MD5Util.md5_private_salt(userId.toString(), salt);
        user.setPassword(password);
        user.setSalt(salt);
        super.updateById(user);
        return true;
    }


}
