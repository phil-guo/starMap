package com.act.core.domain;

import com.act.core.utils.HttpContextUtils;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @author phil.guo
 */
@Data
public abstract class BaseEntity<T> implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private T id;

    @TableField(value = "isDelete", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete = 0;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime = LocalDateTime.now();

    @TableField(value = "createUser", fill = FieldFill.INSERT)
    private String createUser;// = HttpContextUtils.getUserContext().getName();

    @TableField(value = "createUserId", fill = FieldFill.INSERT)
    private T createUserId;// = (T) HttpContextUtils.getUserContext().getUserId();

    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;// = LocalDateTime.now();

    @TableField(value = "updateUser", fill = FieldFill.UPDATE)
    private String updateUser;// = HttpContextUtils.getUserContext().getName();

    @TableField(value = "updateUserId", fill = FieldFill.UPDATE)
    private T updateUserId;// = (T) HttpContextUtils.getUserContext().getUserId();
}
