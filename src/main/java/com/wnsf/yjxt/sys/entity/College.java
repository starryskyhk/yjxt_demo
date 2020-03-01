package com.wnsf.yjxt.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学院表
 * </p>
 *
 * @author 韩坤
 * @since 2020-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学院Id
     */
    @TableId(value = "college_id", type = IdType.AUTO)
    private Integer collegeId;

    /**
     * 学院名
     */
    private String name;


}
