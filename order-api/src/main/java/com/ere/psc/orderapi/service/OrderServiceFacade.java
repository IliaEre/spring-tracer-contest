package com.ere.psc.orderapi.service;

import com.ere.psc.orderapi.config.ClassLogger;
import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.service.external.CatalogWebService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceFacade extends ClassLogger implements OrderService {

    private final OrderServiceImpl orderService;
    private final CatalogWebService catalogService;

    public OrderServiceFacade(OrderServiceImpl orderService, CatalogWebService catalogService) {
        this.orderService = orderService;
        this.catalogService = catalogService;
    }

    @Override
    public String create(Order order) {
        order.equipmentUuids()
                .forEach(catalogService::findEquipmentById);

        return orderService.create(order);
    }

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public Optional<Order> findOne(String orderId) {
        return orderService.findOne(orderId);
    }
}
