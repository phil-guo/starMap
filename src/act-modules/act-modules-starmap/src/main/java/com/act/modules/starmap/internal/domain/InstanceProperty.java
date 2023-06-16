package com.act.modules.starmap.internal.domain;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sw_instance_property")
@SuppressWarnings("all")
public class InstanceProperty extends BaseEntity<Long> {
    @TableField("instanceId")
    private Long instanceId;
    @TableField("`key`")
    private String key;
    @TableField("val")
    private String val;
}
