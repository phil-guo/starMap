package com.act.modules.zero.internal.domain;

import com.act.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.UUID;

@Data
@TableName("sys_rolemenu")
@SuppressWarnings("all")
public class SysRoleMenu extends BaseEntity<UUID> {

    //角色Id
    @TableField("roleId")
    private UUID roleId;

    //菜单Id
    @TableField("menuId")
    private UUID menuId;

    //操作
    @TableField("operates")
    private String operates;
}
