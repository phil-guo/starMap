package com.act.core.web;

import com.act.core.application.ICurdAppService;
import com.act.core.application.PageDto;
import com.act.core.application.PagedResultDto;
import com.act.core.application.RemovesDTO;
import com.act.core.domain.BaseEntity;
import com.act.core.utils.AjaxResponse;
import com.github.yulichang.base.MPJBaseMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author phil.guo
 */
public class BaseController<TEntity extends BaseEntity<String>, TEntityDto extends BaseEntity<String>, BP extends MPJBaseMapper<TEntity>> {
    @Autowired
    private ICurdAppService<TEntity, TEntityDto, BP> _crud;

    @ApiOperation(value = "分页查询")
    @PostMapping("pageSearch")
    public AjaxResponse<PagedResultDto> pageSearch(@RequestBody PageDto search) {
        return new AjaxResponse<>(_crud.pageSearch(search));
    }

    @ApiOperation(value = "创建或修改")
    @PostMapping("createOrEdit")
    public AjaxResponse<Object> createOrEdit(@RequestBody TEntityDto model) throws InstantiationException, IllegalAccessException {
        return new AjaxResponse<>(_crud.createOrEdit(model));
    }

    @ApiOperation(value = "删除")
    @PostMapping("remove")
    public AjaxResponse<Object> remove(String id) {
        try {
            _crud.delete(id);
            return new AjaxResponse<>("删除成功");
        } catch (Exception exception) {
            return new AjaxResponse<>(exception.getMessage());
        }
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("removes")
    public AjaxResponse<Object> removes(@RequestBody RemovesDTO ids) {
        try {
            ids.getIds().forEach(id -> {
                _crud.delete(id);
            });
            return new AjaxResponse<>("删除成功");
        } catch (Exception exception) {
            return new AjaxResponse<>(exception.getMessage());
        }
    }
}
