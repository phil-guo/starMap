package com.act.modules.starmap.internal.application.instance.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

@Data
@SuppressWarnings("all")
public class InstanceDTO extends BaseEntity<Long> {
    private String name;
    private String code;
    private String remark;
    private Boolean isPersistence;
}
