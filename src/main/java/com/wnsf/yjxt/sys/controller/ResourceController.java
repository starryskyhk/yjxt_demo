package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.Resource;
import com.wnsf.yjxt.sys.entity.Role;
import com.wnsf.yjxt.sys.service.IResourceService;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/sys/resource")
public class ResourceController {

    @Autowired
    private IResourceService resourceService;
    @GetMapping("/index")
    public String index() {
        return "resource/resource_index";
    }

    @GetMapping
    @ResponseBody
    public List<Resource> data() {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByAsc("order_num");
        List<Resource> list = resourceService.list(queryWrapper);
        return list;
    }
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable Integer parentId, Model model) {
        //获取父节点的名字
        String parentName=resourceService.getNameByResourceId(parentId);
        model.addAttribute("parentId", parentId);
        model.addAttribute("parentName",parentName);
        return "resource/resource_add";
    }

    /**
     * 添加资源
     * @param resource
     * @return
     */
    @PostMapping
    @ResponseBody
    public R add( Resource resource) {
        resourceService.save(resource);
        return R.ok("添加成功");
    }

    @DeleteMapping("/{resourceId}")
    @ResponseBody
    public R delete(@PathVariable Integer resourceId) {
        resourceService.removeById(resourceId);
        return R.ok("删除成功");
    }

    @GetMapping("/update/{resourceId}")
    public String update(@PathVariable Integer resourceId, Model model) {
        Resource resource = resourceService.getById(resourceId);
        //获取父节点的名字
        String parentName=resourceService.getNameByResourceId(resource.getParentId());
        model.addAttribute("resource",resource);
        model.addAttribute("parentName",parentName);
        //解决下拉菜单回显
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        model.addAttribute("list",list);
        return "resource/resource_update";
    }

    @PutMapping
    @ResponseBody
    public R update(Resource resource) {
        resourceService.updateById(resource);
        return R.ok("修改成功");
    }
    /**
     * @Description: 修改角色状态
     * @Param: [roleId, status]
     * @return: com.wnsf.yjxt.common.model.R
     * @Author: 陈啧啧
     * @Date: 2020/4/1
     */
    @PostMapping("/status/{resourceId}/{status}")
    @ResponseBody
    public R status(@PathVariable Integer resourceId,@PathVariable Integer status){
        Resource resource = resourceService.getById(resourceId);
        resource.setStatus(status);
        resourceService.updateById(resource);
        return R.ok("修改成功");
    }
}
