package com.ere.psc.equipmentapi.repository;

import com.ere.psc.equipmentapi.model.entity.Equipment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface EquipmentRepository extends ReactiveMongoRepository<Equipment, String> {
    Mono<Equipment> findByUuid(String uuid);
}
