package com.act.core.mybatisplus;

import com.act.core.utils.HttpContextUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "createUser", () -> HttpContextUtils.getUserContext().getName(), String.class); // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "createUserId", () -> HttpContextUtils.getUserContext().getUserId(), String.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
        this.strictUpdateFill(metaObject, "updateUser", () -> HttpContextUtils.getUserContext().getName(), String.class); // 起始版本 3.3.3(推荐)
        this.strictUpdateFill(metaObject, "updateUserId", () -> HttpContextUtils.getUserContext().getUserId(), String.class); // 起始版本 3.3.3(推荐)
    }


}
