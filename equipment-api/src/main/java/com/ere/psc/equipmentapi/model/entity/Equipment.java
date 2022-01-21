package com.ere.psc.equipmentapi.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;

@Document("equipment")
public record Equipment(
        @Id String id,
        @NotNull String uuid,
        String code,
        String name,
        String size,
        String quality
) {
}
