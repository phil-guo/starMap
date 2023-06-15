package com.act.modules.starmap.internal.application.instance;

import com.act.core.application.CurdAppService;
import com.act.modules.starmap.internal.application.instance.dto.InstanceDTO;
import com.act.modules.starmap.internal.domain.Instance;
import com.act.modules.starmap.internal.mapper.InstanceMapper;
import org.springframework.stereotype.Service;

@Service
public class InstanceServiceImp extends CurdAppService<Instance, InstanceDTO, InstanceMapper> implements InstanceService{
}
