package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.common.model.Select2;
import com.wnsf.yjxt.common.model.TreeNode;
import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.entity.RoleResource;
import com.wnsf.yjxt.sys.service.IResourceService;
import com.wnsf.yjxt.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表
 * 前端控制器
 * </p>
 *
 * @author 陈泽
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourceService;

    @GetMapping("/index")
    public String index() {
        return "role/role_list";
    }

    /**
     * 角色列表
     * @return
     */
    @GetMapping
    @ResponseBody
    public List<Role> data() {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByAsc("order_num");
        List list = roleService.list(queryWrapper);
        return list;
    }


    @GetMapping("/add")
    public String add() {
        return "role/role_add";
    }

    /**
     * 添加角色
     * @param role   角色名字
     * @param roleIds 角色的资源
     * @return
     */
    @PostMapping
    @ResponseBody
    public R add(Role role, @RequestParam(name = "roleIds[]") String[] roleIds) {
        roleService.addRole(role,roleIds);
        return R.ok("添加成功");
    }

    @GetMapping("/update/{roleId}")
    public String update(@PathVariable Integer roleId, Model model) {
        Role role = roleService.getById(roleId);
        model.addAttribute("role", role);
        return "role/role_update";
    }

    /**
     * 修改角色
     * @param role
     * @param roleIds
     * @return
     */
    @PutMapping
    @ResponseBody
    public R update(Role role,@RequestParam(name = "roleIds[]") String[] roleIds) {
        roleService.updateRole(role,roleIds);
        return R.ok("修改成功");
    }

    @DeleteMapping("/{roleId}")
    @ResponseBody
    public R delete(@PathVariable Integer roleId) {
        roleService.removeById(roleId);
        return R.ok("删除成功");
    }


    /**
     * 获取role的资源json字符串
     */
    @GetMapping("/resource/{roleId}")
    @ResponseBody
    public List<RoleResource> assign(@PathVariable Integer roleId) {
        return roleService.getResource(roleId);
    }

    /**
     * 初始化资源json串
     */
    @GetMapping("/resource")
    @ResponseBody
    public List<RoleResource> assign() {
        return roleService.getResource();
    }

    /**
    * @Description: 修改角色状态
    * @Param: [roleId, status]
    * @return: com.wnsf.yjxt.common.model.R
    * @Author: 陈啧啧
    * @Date: 2020/4/1
    */
    @PostMapping("/status/{roleId}/{status}")
    @ResponseBody
    public R status(@PathVariable Integer roleId,@PathVariable Integer status){
        Role role = roleService.getById(roleId);
        role.setStatus(status);
        roleService.updateById(role);
        return R.ok("修改成功");
    }

}
