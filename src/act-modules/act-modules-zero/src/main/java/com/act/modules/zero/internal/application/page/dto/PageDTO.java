package com.act.modules.zero.internal.application.page.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

@Data
@SuppressWarnings("all")
public class PageDTO extends BaseEntity<Long> {
    private String name;
    private String key;
}
