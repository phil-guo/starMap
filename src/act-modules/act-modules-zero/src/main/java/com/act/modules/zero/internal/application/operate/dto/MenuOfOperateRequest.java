package com.act.modules.zero.internal.application.operate.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuOfOperateRequest {
    private UUID roleId;
    private UUID menuId;
}


