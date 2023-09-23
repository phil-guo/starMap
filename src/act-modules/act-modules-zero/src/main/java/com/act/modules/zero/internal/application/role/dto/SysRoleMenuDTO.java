package com.act.modules.zero.internal.application.role.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysRoleMenuDTO extends BaseEntity<String> {

    //角色Id
    private String roleId;

    //菜单Id
    private String menuId;

    //操作
    private String operates;
}
