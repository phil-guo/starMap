package com.act.modules.zero.internal.application.menu.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysMenuDTO extends BaseEntity<String> {

    private String parentId;

    private String name;

    private String url;

    private int level;

    private String operates;

    private int sort;

    private String icon;

    private String key;

    private Boolean isLeftShow;

    private List<SysMenuDTO> children = new ArrayList<>();
}
