package com.act.modules.zero.internal.application.dictionary;

import com.act.core.utils.*;
import com.act.modules.zero.internal.mapper.SysDictionaryMapper;
import com.act.core.application.ComBoxInfo;
import com.act.core.application.CurdAppService;
import com.act.modules.zero.internal.application.dictionary.dto.SysDictionaryDTO;
import com.act.modules.zero.internal.domain.SysDataDictionary;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@SuppressWarnings("all")
public class SysDictionaryServiceImp extends CurdAppService<SysDataDictionary, SysDictionaryDTO, SysDictionaryMapper>
        implements SysDictionaryService {

    public AjaxResponse<Object> getDictionaryByGroup(String groupName) {

        var data = Table()
                .selectList(new LambdaQueryWrapper<SysDataDictionary>()
                        .eq(SysDataDictionary::getGroup, groupName));

        var result = BeanUtilsExtensions.copyListProperties(data, ComBoxInfo::new);
        return new AjaxResponse<Object>(data);
    }

    @Override
    public void delete(String id) throws FriendlyException {
        var entity = getById(id);
        var claimsUserInfo = HttpContextUtils.getUserContext();
        if (entity.getIsBasicData() && claimsUserInfo.getUserId() != StringExtensions.UUID_SUPER_ADMIN)
            throw new FriendlyException("非超级管理员不能删除基础数据");
        super.delete(id);
    }

    @Override
    protected void beforeEdit(SysDictionaryDTO request) {
        var claimsUserInfo = HttpContextUtils.getUserContext();
        if (request.getIsBasicData() && !claimsUserInfo.getUserId().equals(StringExtensions.UUID_SUPER_ADMIN))
            throw new FriendlyException("非超级管理员不能修改基础数据");
    }
}
