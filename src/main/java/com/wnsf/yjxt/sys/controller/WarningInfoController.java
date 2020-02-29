package com.wnsf.yjxt.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 预警信息表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Controller
@RequestMapping("/sys/warning-info")
public class WarningInfoController {
    //跳转到学院预警列表
    @GetMapping("list")
    public String list(){
        return "warning/warning_list_college";
    }



}
