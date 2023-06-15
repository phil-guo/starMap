package com.act.modules.starmap.internal.controllers;

import com.act.core.web.BaseController;
import com.act.modules.starmap.internal.application.instance.dto.InstanceDTO;
import com.act.modules.starmap.internal.domain.Instance;
import com.act.modules.starmap.internal.mapper.InstanceMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "数据实例配置")
@RestController
@RequestMapping("/api/v1/instance/")
public class InstanceController extends BaseController<Instance, InstanceDTO, InstanceMapper> {
}
