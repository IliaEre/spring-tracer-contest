package com.ere.psc.equipmentapi.api.model;

import java.time.OffsetDateTime;

public record BlockResponse(
        String uuid,
        String status,
        OffsetDateTime expirationTime
) {}
