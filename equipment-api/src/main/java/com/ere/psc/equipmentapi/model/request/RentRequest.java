package com.ere.psc.equipmentapi.api.model;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public record RentRequest(
        @NotNull OffsetDateTime from
) {
}
