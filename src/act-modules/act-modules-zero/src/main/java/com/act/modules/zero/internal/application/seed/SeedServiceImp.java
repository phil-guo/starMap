package com.act.modules.zero.internal.application.seed;

import com.act.core.utils.BeanUtilsExtensions;
import com.act.core.utils.HttpContextUtils;
import com.act.core.utils.StringExtensions;
import com.act.modules.zero.internal.application.user.SysUserService;
import com.act.modules.zero.internal.application.user.dto.SysUserDTO;
import com.act.modules.zero.internal.domain.SysRole;
import com.act.modules.zero.internal.domain.SysUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class SeedServiceImp implements SeedService {

    @Autowired
    private SysUserService _user;

    private SysRole _role;

    public void seedData() throws InstantiationException, IllegalAccessException {

        //超级管理员
        var user = new SysUser();
        user.setRoleIds(StringExtensions.UUID_SUPER_ADMIN.toString());
        user.setId(StringExtensions.UUID_SUPER_ADMIN);
        user.setUserName("admin");
        user.setPassword(StringExtensions.ToMd5("123qwe"));
        user.setCreateUser(HttpContextUtils.getUserContext().getName());
        user.setCreateUserId(HttpContextUtils.getUserContext().getUserId());
        _user.save(user);

        //角色
    }


    public void seedRoleData() throws InstantiationException, IllegalAccessException {
        var user = _user.Table().selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getId, StringExtensions.UUID_SUPER_ADMIN));
        user.setIcon("123");
        var dto = new SysUserDTO();
        BeanUtilsExtensions.copyProperties(user, dto);
        _user.createOrEdit(dto);
    }
}

