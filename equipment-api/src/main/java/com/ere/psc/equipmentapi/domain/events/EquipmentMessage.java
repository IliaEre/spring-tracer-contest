package com.ere.psc.equipmentapi.domain.events;

import com.ere.psc.equipmentapi.model.dto.EquipmentDto;

public record EquipmentMessage(
        String userUuid,
        EquipmentsEvent event,
        EquipmentDto equipmentDto
) {
}
