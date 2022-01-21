package com.ere.psc.equipmentapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EquipmentResponse(
        String uuid,
        String code,
        String name,
        String size,
        String quality
) {}
