package com.wnsf.yjxt.sys.service.impl;

import com.wnsf.yjxt.sys.entity.Operatorlog;
import com.wnsf.yjxt.sys.mapper.OperatorlogMapper;
import com.wnsf.yjxt.sys.service.IOperatorlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author 韩坤
 * @since 2020-02-26
 */
@Service
public class OperatorlogServiceImpl extends ServiceImpl<OperatorlogMapper, Operatorlog> implements IOperatorlogService {

}
