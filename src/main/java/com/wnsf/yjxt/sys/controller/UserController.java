package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.service.IRoleService;
import com.wnsf.yjxt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈啧啧
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /**
     * 获取管理员列表
     * @return
     */
    @GetMapping
    @ResponseBody
    public List<User> data(){
        return userService.getAdminList();
    }

    /**
     * 用户列表主页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "user/user_list";
    }

    /**
     * 添加用户页面
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "user/user_add";
    }

    /**
     * 添加用户
     * @param user 添加的对象
     * @param roleIds 添加对象拥有的资源
     * @return
     */
    @PostMapping
    @ResponseBody
    public R add(User user,@RequestParam(name = "roleIds[]",required = false) String[] roleIds){

        userService.savaUserAndRoleids(user,roleIds);
        return R.ok("添加成功");
    }
    /**
     * 获取user拥有的角色id
     * @return
     */
    @GetMapping("/select2/{userId}")
    @ResponseBody
    public List<Select2> select2List(@PathVariable Integer userId){
        List<Select2> select2s = userService.select2List(userId);
        return select2s;
    }
    /**
     * 初始化select2
     * @return
     */
    @GetMapping("/select2")
    @ResponseBody
    public List<Select2> select2List1(){
        List<Select2> select2s = userService.select2List(null);
        return select2s;
    }
    /**
     * 更新用户页面
     * @return
     */
    @GetMapping("/update/{userId}")
    public String update(@PathVariable Integer userId,Model model){
        User user =userService.getById(userId);
        model.addAttribute("user",user);
        return "user/user_update";
    }

    /**
     * 修改用户
     * @param user
     * @param roleIds
     * @return
     */
    @PutMapping()
    @ResponseBody
    public R update(User user,@RequestParam(name = "roleIds[]",required = false) String[] roleIds){
        //修改用户
        userService.updateUserAndRoleids(user,roleIds);
        return R.ok("修改成功");
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @DeleteMapping("{userId}")
    @ResponseBody
    public R delete(@PathVariable Integer userId){
        userService.removeByAdminId(userId);
        return R.ok("删除成功");
    }

    /**
     * 重置密码
     * @param userId
     * @return
     */
    @PostMapping("/recover/{userId}")
    @ResponseBody
    public R recover(@PathVariable Integer userId){
        //重置密码
        userService.resetUserPassword(userId);
        return R.ok("重置密码成功");
    }
}
