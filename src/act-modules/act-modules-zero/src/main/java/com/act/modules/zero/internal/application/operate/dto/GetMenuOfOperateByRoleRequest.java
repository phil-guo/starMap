package com.act.modules.zero.internal.application.operate.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GetMenuOfOperateByRoleRequest {
    private String roleId;
    private String key;
}
