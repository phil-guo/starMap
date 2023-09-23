package com.act.modules.zero.internal.application.user.dto;

import com.act.core.domain.BaseEntity;
import lombok.Data;

import java.util.UUID;

@Data
@SuppressWarnings("all")
public class SysUserDTO extends BaseEntity<UUID> {

    //角色Id
    private String roleIds;

    //用户名
    private String userName;

    //密码
    private String password;

    //头像
    private String icon;

    private String roleName;
}
