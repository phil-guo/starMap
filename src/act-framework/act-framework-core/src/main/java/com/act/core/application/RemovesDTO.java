package com.act.core.application;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class RemovesDTO {
    private List<UUID> ids = new ArrayList<>();
}
