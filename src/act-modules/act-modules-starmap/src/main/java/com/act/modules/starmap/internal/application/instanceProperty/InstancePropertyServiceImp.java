package com.act.modules.starmap.internal.application.instanceProperty;

import com.act.core.application.CurdAppService;
import com.act.modules.starmap.internal.application.instanceProperty.dto.InstancePropertyDTO;
import com.act.modules.starmap.internal.domain.InstanceProperty;
import com.act.modules.starmap.internal.mapper.InstancePropertyMapper;
import org.springframework.stereotype.Service;

@Service
public class InstancePropertyServiceImp extends CurdAppService<InstanceProperty, InstancePropertyDTO, InstancePropertyMapper> implements InstancePropertyService {
}
