package com.act.modules.zero.internal.application.menu.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class MenusRoleResponse {
    private UUID id;
    private String title;
    private String icon;
    private String path;
    private String key;
    private List<MenusRoleResponse> children = new ArrayList<>();
}
