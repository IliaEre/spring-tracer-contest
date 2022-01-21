package com.ere.psc.equipmentapi.model.request;

import javax.validation.constraints.NotNull;

public record CreateEquipmentRequest(
        @NotNull String uuid,
        @NotNull String code,
        String name,
        @NotNull String size,
        String quality
) {}
