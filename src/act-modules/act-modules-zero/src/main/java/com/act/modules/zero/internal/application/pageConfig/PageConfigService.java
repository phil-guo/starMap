package com.act.modules.zero.internal.application.pageConfig;

import com.act.modules.zero.internal.application.pageConfig.dto.PageConfigDTO;
import com.act.modules.zero.internal.mapper.PageConfigMapper;
import com.act.core.application.ICurdAppService;
import com.act.modules.zero.internal.domain.PageConfig;

@SuppressWarnings("all")
public interface PageConfigService extends ICurdAppService<PageConfig, PageConfigDTO, PageConfigMapper> {
}
