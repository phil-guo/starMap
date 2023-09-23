package com.act.modules.zero.internal.application.operate.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysOperateDTO extends BaseEntity<String> {
    private String name;
    private int unique;
    private Boolean isBasicData;
    private String remark;
}
