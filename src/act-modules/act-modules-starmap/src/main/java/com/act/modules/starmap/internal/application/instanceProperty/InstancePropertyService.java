package com.act.modules.starmap.internal.application.instanceProperty;

import com.act.core.application.ICurdAppService;
import com.act.modules.starmap.internal.application.instanceProperty.dto.InstancePropertyDTO;
import com.act.modules.starmap.internal.domain.InstanceProperty;
import com.act.modules.starmap.internal.mapper.InstancePropertyMapper;

public interface InstancePropertyService  extends ICurdAppService<InstanceProperty, InstancePropertyDTO, InstancePropertyMapper> {
}
