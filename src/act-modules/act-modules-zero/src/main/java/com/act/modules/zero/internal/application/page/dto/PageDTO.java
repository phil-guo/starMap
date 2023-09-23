package com.act.modules.zero.internal.application.page.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class PageDTO extends BaseEntity<String> {
    private String name;
    private String key;
}
