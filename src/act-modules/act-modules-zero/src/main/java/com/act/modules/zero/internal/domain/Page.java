package com.act.modules.zero.internal.domain;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.UUID;

@Data
@TableName("dc_page")
@SuppressWarnings("all")
public class Page extends BaseEntity<UUID> {
    @TableField("name")
    private String name;
    @TableField("`key`")
    private String key;
}
