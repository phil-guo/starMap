package com.act.core.utils;

import com.act.core.domain.UserInfoContext;
import lombok.var;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public class HttpContextUtils {

    /**
     * 获取当前用户上下文
     *
     * @return
     */
    public static UserInfoContext getUserContext() {
        var map = getHttpContext();

        var userContext = new UserInfoContext();

        userContext.setUserId((UUID) map.get(UserInfoContext.userIdPrex));
        userContext.setName((String) map.get(UserInfoContext.userNamePrex));
        userContext.setRoleId((String) map.get(UserInfoContext.roleIdPrex));
        userContext.setUserIcon((String) map.get(UserInfoContext.userIconPrex));
        return userContext;
    }

    private static Map<String, Object> getHttpContext() {
        var context = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        var token = context.getHeader("Authorization").replace("Bearer ", "");
        var result = JWTUtils.parseClaimsJws(token);
        return result;
    }
}

