package com.wnsf.yjxt.sys.controller;


import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.Role;
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
 * @author 韩坤
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping("/index")
    public String index() {
        return "role/role_list";
    }

    @GetMapping
    @ResponseBody
    public List<Role> data() {
        List<Role> list = roleService.list();
        return list;
    }

    @GetMapping("/add")
    public String add(){
        return "role/role_add";
    }
    @PostMapping("/add")
    @ResponseBody
    public R add(@RequestBody Role role){
        roleService.save(role);
        return R.ok("添加成功");
    }

    @GetMapping("/update")
    public String update(){
        return "role/role_update";
    }
    @PutMapping("/update")
    @ResponseBody
    public R update(@RequestBody Role role){
        roleService.updateById(role);
        return R.ok("修改成功");
    }
}
