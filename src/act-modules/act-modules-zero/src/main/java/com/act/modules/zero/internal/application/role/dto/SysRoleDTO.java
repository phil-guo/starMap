package com.act.modules.zero.internal.application.role.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysRoleDTO extends BaseEntity<UUID> {

    /*名称*/
    private String name;

    /*备注*/
    private String remark;
}
