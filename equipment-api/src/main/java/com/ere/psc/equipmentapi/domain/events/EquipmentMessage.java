package com.ere.psc.equipmentapi.domain.events;

import com.ere.psc.equipmentapi.model.entity.Equipment;

public record EquipmentMessage(
        String userUuid,
        EquipmentsEvent event,
        Equipment equipmentDto
) {
}
