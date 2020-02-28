package com.wnsf.yjxt.sys.controller;


import com.wnsf.yjxt.sys.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 学院表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Controller
@RequestMapping("/sys/college")
public class CollegeController {
    @Autowired
    ICollegeService collegeService;
    @RequestMapping("hello")
    public String hello(){
        return "index";
    }

}
