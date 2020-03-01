package com.wnsf.yjxt.sys.controller;


import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.StudentInfo;
import com.wnsf.yjxt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @Autowired
    private IUserService userService;


    //跳转到学院预警列表
    @GetMapping("list")
    public String list(){
        return "warning/warning_list_college";
    }



}
