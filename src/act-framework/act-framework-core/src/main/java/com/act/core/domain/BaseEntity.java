package com.act.core.domain;

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

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime = LocalDateTime.now();

    @TableField(value = "isDelete", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDelete = 0;
}
