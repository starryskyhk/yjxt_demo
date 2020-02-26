package com.wnsf.yjxt.sys.controller;


import com.wnsf.yjxt.sys.entity.College;
import com.wnsf.yjxt.sys.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学院表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@RestController
@RequestMapping("/sys/college")
public class CollegeController {
    @Autowired
    ICollegeService collegeService;
    @RequestMapping("hello")
    public College hello(){
        College college = collegeService.getById(1);
        System.out.println(college);
        return college;
    }

}
