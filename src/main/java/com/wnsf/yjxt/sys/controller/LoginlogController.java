package com.wnsf.yjxt.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录日志表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/index")
public class LoginlogController {
    @GetMapping
    public String index(){
        return "index";
    }
}
