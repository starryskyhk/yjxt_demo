package com.wnsf.yjxt.sys.mapper;

import com.wnsf.yjxt.sys.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Component
public interface ResourceMapper extends BaseMapper<Resource> {
    /**
     * 
     * @return
     */
    List<Resource> list();
}
