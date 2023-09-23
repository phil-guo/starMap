package com.act.modules.zero.internal.application.role.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class RoleMenuDTO {
    private UUID id;
    private UUID parentId;
    private String title;
    private String icon;
    private String path;
    private String key;
    private List<RoleMenuDTO> children= new ArrayList<>();
    private String operates;
}
