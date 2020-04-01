package com.wnsf.yjxt.common.model;

import lombok.Data;

/**
 * select2的初始化类
 */
@Data
public class Select2 {
    private Integer id;
    private String text;
    private Boolean selected = false;
}
