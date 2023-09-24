package com.act.modules.zero.internal.application.role.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SetRolePermissionRequest {
    private String roleId;
    private ArrayList<String> menuIds = new ArrayList<>();
}
