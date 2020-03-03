package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.Resource;
import com.wnsf.yjxt.sys.service.IResourceService;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        //QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByAsc("order_num");
        List<Resource> list = resourceService.list();
        return list;
    }

    @GetMapping("/add")
    public String add( Integer parentId, Model model) {
        model.addAttribute("parentId", parentId);
        return "resource/resource_add";
    }

    @PostMapping("/add")
    @ResponseBody
    public R add(Resource resource) {

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
        model.addAttribute("resource", resourceService.getById(resourceId));
        return "resource/resource_update";
    }

    @PutMapping
    @ResponseBody
    public R update(@RequestBody Resource resource) {
        resourceService.updateById(resource);
        return R.ok("修改成功");
    }
}
