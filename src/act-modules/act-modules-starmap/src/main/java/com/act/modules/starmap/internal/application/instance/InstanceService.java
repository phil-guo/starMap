package com.act.modules.starmap.internal.application.instance;

import com.act.core.application.ICurdAppService;
import com.act.modules.starmap.internal.application.instance.dto.InstanceDTO;
import com.act.modules.starmap.internal.domain.Instance;
import com.act.modules.starmap.internal.mapper.InstanceMapper;

public interface InstanceService  extends ICurdAppService<Instance, InstanceDTO, InstanceMapper> {
}
