package com.ere.psc.orderapi.model.dto;

import com.ere.psc.orderapi.model.UserInfo;
import com.ere.psc.orderapi.model.enums.RentType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document("orders")
public record OrderDocument(
        @Id String orderId,
        @NotNull UserInfo userInfo,
        String skiPassId,
        RentType rentType,
        List<String> equipment,
        String timeStamp
) {}
