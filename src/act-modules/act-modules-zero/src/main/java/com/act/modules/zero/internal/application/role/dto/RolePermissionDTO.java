package com.act.modules.zero.internal.application.role.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class RolePermissionDTO {

    private UUID menuId;
    private ArrayList<UUID> operates = new ArrayList<>();

}
