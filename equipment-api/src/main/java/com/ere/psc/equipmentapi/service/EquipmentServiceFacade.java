package com.ere.psc.equipmentapi.service;

import com.ere.psc.equipmentapi.model.request.CreateEquipmentRequest;
import com.ere.psc.equipmentapi.model.response.EquipmentResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Equipment facade for metrics
 * */
@Component("EquipmentServiceFacade")
public class EquipmentServiceFacade implements EquipmentService {

    private final EquipmentService equipmentService;

    public EquipmentServiceFacade(@Qualifier("EquipmentService") EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Override
    public Mono<EquipmentResponse> findByUuid(String uuid) {
        return equipmentService.findByUuid(uuid)
                .metrics()
                .name("findOne")
                .tag("service", "findOne");
    }

    @Override
    public Flux<EquipmentResponse> findAll() {
        return equipmentService.findAll()
                .metrics()
                .name("findAll")
                .tag("service", "findAll");
    }

    @Override
    public Mono<String> create(CreateEquipmentRequest equipment) {
        return equipmentService.create(equipment)
                .metrics()
                .name("create")
                .tag("service", "create");
    }
}
