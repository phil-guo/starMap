package com.act.modules.zero.internal.application.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdatePersonalInfoRequest {
    private UUID userId;
    private String userName;
    private String password;
    private String icon;
}
