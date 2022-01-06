package com.ere.psc.orderapi.model;

import com.ere.psc.orderapi.model.enums.RentType;
import jdk.jfr.Timestamp;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

public record Order(
        @Id String orderId,
        @NotNull UserInfo userInfo,
        String skiPassId,
        RentType rentType,
        List<Equipment> equipment,
        @Timestamp OffsetDateTime timeStamp
) {}
