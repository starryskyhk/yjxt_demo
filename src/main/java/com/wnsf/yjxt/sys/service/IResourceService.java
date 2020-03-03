package com.wnsf.yjxt.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wnsf.yjxt.sys.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
public interface IResourceService extends IService<Resource> {

}
