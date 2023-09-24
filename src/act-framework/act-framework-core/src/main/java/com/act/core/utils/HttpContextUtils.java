package com.act.core.utils;

import com.act.core.domain.UserInfoContext;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.var;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public final class HttpContextUtils {

    static HashMap<String, Object> SeedMap = new HashMap<>();

    public static UserInfoContext getUserContext() {
        return getUserContext(false);
    }

    /**
     * 获取当前用户上下文
     *
     * @return
     */
    public static UserInfoContext getUserContext(boolean hasSeedData) {

        var userInfo = new UserInfoContext();

        var map = getHttpContext(hasSeedData);

        userInfo.setUserId(StringUtils.isEmpty((String) map.get(UserInfoContext.userIdPrex))
                ? StringExtensions.UUID_SUPER_ADMIN
                : (String) map.get(UserInfoContext.userIdPrex));
        userInfo.setName(StringUtils.isEmpty((String) map.get(UserInfoContext.userNamePrex))
                ? "admin"
                : (String) map.get(UserInfoContext.userNamePrex));
        userInfo.setRoleId(StringUtils.isEmpty((String) map.get(UserInfoContext.roleIdPrex))
                ? StringExtensions.UUID_SUPER_ADMIN.toString()
                : (String) map.get(UserInfoContext.roleIdPrex));
        userInfo.setUserIcon((String) map.get(UserInfoContext.userIconPrex));

        return userInfo;
    }

    private static Map<String, Object> getHttpContext(boolean hasSeedData) {

        if (hasSeedData) {
            SeedMap.put("1", 1);
            return new HashMap<>();
        }
        if (!hasSeedData && SeedMap.size() == 0) {
            var context = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            var header = context.getHeader("Authorization");
            var token = header.replace("Bearer ", "");
            var result = JWTUtils.parseClaimsJws(token);
            return result;
        } else {
            return new HashMap<>();
        }
    }
}

