package com.ere.psc.orderapi.utils;

import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.model.dto.OrderDocument;
import java.time.OffsetDateTime;

public final class OrderMapper {

    public static OrderDocument convertTo(Order order) {
        return new OrderDocument(
                null, order.userInfo(), order.skiPassId(),
                order.rentType(), order.equipmentUuids(),
                order.timeStamp().toString());
    }

    public static Order convertTo(OrderDocument orderDocument) {
        return new Order(
                orderDocument.userInfo(),
                orderDocument.skiPassId(),
                orderDocument.rentType(),
                orderDocument.equipment(),
                OffsetDateTime.parse(orderDocument.timeStamp())
        );
    }

}
