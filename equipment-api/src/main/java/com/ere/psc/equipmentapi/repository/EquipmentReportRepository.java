package com.ere.psc.equipmentapi.repository;

import com.ere.psc.equipmentapi.model.dto.EquipmentDto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface EquipmentRepository extends ReactiveMongoRepository<EquipmentDto, String> {
    Mono<EquipmentDto> findByUuid(String uuid);
}
