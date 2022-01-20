package com.ere.psc.equipmentapi.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("equipment_report")
public record EquipmentReportDto(
        @Id String id,
        String uuid,
        String code,
        String status,
        String from,
        String to
) implements EquipmentMarker {
}
