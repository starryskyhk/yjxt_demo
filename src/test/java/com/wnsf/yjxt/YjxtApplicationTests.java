package com.wnsf.yjxt;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.wnsf.yjxt.sys.entity.Major;
import com.wnsf.yjxt.sys.entity.StudentInfo;
import com.wnsf.yjxt.sys.service.IMajorService;
import com.wnsf.yjxt.sys.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class YjxtApplicationTests {

    @Autowired
    private IMajorService majorService;

    /**
     * 生成专业信息
     */
    @Test
    public void excelTest(){
        List<Major> list=new ArrayList<Major>();

        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\Starry_sky\\Desktop\\college.xlsx"));
        List<Map<String, Object>> maps = reader.readAll();
        int i=1;
        Collection<Major> majors=new ArrayList<Major>();
        for(Map<String,Object> map:maps){

            Major major=new Major();
            major.setMajorId(i++);
            major.setName((String) map.get("专业"));
            major.setCollegeId(Integer.valueOf(map.get("学院").toString()));
            majors.add(major);

        }
       // System.out.println(majors);
       majorService.saveBatch(majors);


    }
    @Autowired
    private IUserService userService;
    @Test
    public void test(){
        List<StudentInfo> studentInfo = userService.getStudentInfo();
        System.out.println(studentInfo);
    }

}
