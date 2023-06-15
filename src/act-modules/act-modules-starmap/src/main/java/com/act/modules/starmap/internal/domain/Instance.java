package com.act.modules.starmap.internal.domain;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sw_instance")
@SuppressWarnings("all")
public class Instance extends BaseEntity<Long> {
    @TableField("name")
    private String name;
    @TableField("code")
    private String code;
    @TableField("remark")
    private String remark;
    @TableField("isPersistence")
    private Boolean isPersistence;
}
