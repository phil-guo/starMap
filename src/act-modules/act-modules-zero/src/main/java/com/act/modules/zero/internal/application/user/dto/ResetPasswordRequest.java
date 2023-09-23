package com.act.modules.zero.internal.application.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ResetPasswordRequest {
    private UUID userId;
}
