package com.ere.psc.orderapi.model;

import com.ere.psc.orderapi.model.enums.RentType;
import jdk.jfr.Timestamp;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

public record Order(
        @NotNull UserInfo userInfo,
        String skiPassId,
        RentType rentType,
        List<String> equipmentUuids,
        @Timestamp OffsetDateTime timeStamp
) {}
