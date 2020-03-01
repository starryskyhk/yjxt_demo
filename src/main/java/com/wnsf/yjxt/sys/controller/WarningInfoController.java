package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 预警信息表 前端控制器
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
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

    //获取预警学生列表
    @GetMapping("data")
    @ResponseBody
    public R data(@RequestParam(required = false) Map<String,Object> map, Page<User> page){
        //1:创建条件构造器
        QueryWrapper wrapper=new QueryWrapper();
        //**未知来处的属性,移除
        map.remove("_");
        //3:遍历条件集合map
        for(Map.Entry<String, Object> entry : map.entrySet()){
            //3.1获取值
            Object mapValue = entry.getValue();
            //3.2如果值不为空,拼接字符串
            if(mapValue!=null&&mapValue!=""){
                String mapKey = entry.getKey();
                wrapper.like(mapKey, mapValue);
            }

        }
        //调用方法,此方法拥有分页和条件查询功能
        userService.getStudentInfo(page, wrapper);
        return R.ok(page);

    }
}
