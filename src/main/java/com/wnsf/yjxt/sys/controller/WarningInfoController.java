package com.wnsf.yjxt.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wnsf.yjxt.common.model.R;
import com.wnsf.yjxt.sys.entity.StudentScore;
import com.wnsf.yjxt.sys.entity.User;
import com.wnsf.yjxt.sys.service.IScoreService;
import com.wnsf.yjxt.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private IScoreService scoreService;

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
    //将此行学生的数据转发到成绩列表页面
    @GetMapping("/score/{userId}")
    public String score(@PathVariable String userId, Model model){

        User user=userService.getStudentInfoById(userId);
        System.out.println("user:"+user);
        model.addAttribute("user", user);

        return "warning/score";
    }

    //获取当前学生的成绩信息
    @GetMapping("/scorelist")
    @ResponseBody
    public R scorelist(Page<StudentScore> page, Integer userId){
        //1:创建条件构造器
        QueryWrapper wrapper=new QueryWrapper();
        //2:设置条件
        wrapper.eq("user_id", userId);
        //3:查询
        scoreService.getStudentScore(page,wrapper);
        return R.ok(page);
    }
}
