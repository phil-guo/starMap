package com.act.modules.starmap.internal.application.instanceProperty.dto;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
@SuppressWarnings("all")
public class InstancePropertyDTO extends BaseEntity<Long> {
    private Long instanceId;
    private String key;
    private String val;
}
