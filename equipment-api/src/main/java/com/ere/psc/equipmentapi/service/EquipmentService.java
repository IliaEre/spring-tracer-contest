package com.ere.psc.equipmentapi.service;

import com.ere.psc.equipmentapi.model.request.CreateEquipmentRequest;
import com.ere.psc.equipmentapi.model.response.EquipmentResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EquipmentService {
    Mono<EquipmentResponse> findByUuid(String uuid);
    Flux<EquipmentResponse> findAll();
    Mono<String> create(CreateEquipmentRequest equipment);
}
