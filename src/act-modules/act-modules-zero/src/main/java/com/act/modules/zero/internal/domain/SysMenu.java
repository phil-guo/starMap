package com.act.modules.zero.internal.domain;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.UUID;

/**
 *
 */
@Data
@TableName("sys_menu")
@SuppressWarnings("all")
public class SysMenu extends BaseEntity<String> {

    @TableField("parentId")
    private String parentId;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("level")
    private int level = 0;

    @TableField("operates")
    private String operates;

    @TableField("sort")
    private int sort = 0;

    @TableField("icon")
    private String icon;

    @TableField("`key`")
    private String key;

    @TableField("isLeftShow")
    private Boolean isLeftShow = false;

    public int AddOperateSort() {
        sort += 1;
        return sort;
    }
}
