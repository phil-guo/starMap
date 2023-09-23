package com.act.modules.zero.internal.application.dictionary.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysDictionaryDTO extends BaseEntity<String> {
    private String key;
    private String value;
    private String group;
    private Boolean isBasicData;
}
