package com.act.core.application;

import com.act.core.domain.BaseEntity;
import com.act.core.utils.FriendlyException;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.yulichang.base.MPJBaseMapper;

import java.util.UUID;

@SuppressWarnings("all")
public interface ICurdAppService<TEntity extends BaseEntity<UUID>,
        TEntityDto extends BaseEntity<UUID>,
        BP extends MPJBaseMapper<TEntity>> extends IService<TEntity> {

    /**
     * 获取仓储上下文
     *
     * @return
     */
    BP Table();

    /**
     * 分页查询
     *
     * @param search
     * @return
     */
    PagedResultDto pageSearch(PageDto search);

    /**
     * 添加或删除
     *
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws FriendlyException
     */
    TEntityDto createOrEdit(TEntityDto request) throws InstantiationException, IllegalAccessException, FriendlyException;

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(UUID id) throws FriendlyException;
}
