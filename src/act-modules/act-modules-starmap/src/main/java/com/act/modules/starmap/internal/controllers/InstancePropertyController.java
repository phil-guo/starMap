package com.act.modules.starmap.internal.controllers;

import com.act.core.web.BaseController;
import com.act.modules.starmap.internal.application.instanceProperty.dto.InstancePropertyDTO;
import com.act.modules.starmap.internal.domain.InstanceProperty;
import com.act.modules.starmap.internal.mapper.InstancePropertyMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "实例属性配置")
@RestController
@RequestMapping("/api/v1/instanceProperty/")
public class InstancePropertyController  extends BaseController<InstanceProperty, InstancePropertyDTO, InstancePropertyMapper> {
}
