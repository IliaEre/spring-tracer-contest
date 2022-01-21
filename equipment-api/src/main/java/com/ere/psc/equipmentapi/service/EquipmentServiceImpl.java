package com.ere.psc.equipmentapi.service;

import com.ere.psc.equipmentapi.config.AbstractLogger;
import com.ere.psc.equipmentapi.domain.exception.EquipmentNotFoundException;
import com.ere.psc.equipmentapi.model.entity.Equipment;
import com.ere.psc.equipmentapi.model.request.CreateEquipmentRequest;
import com.ere.psc.equipmentapi.model.response.EquipmentResponse;
import com.ere.psc.equipmentapi.repository.EquipmentRepository;
import com.ere.psc.equipmentapi.service.mapper.EquipmentConvertor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("EquipmentService")
public class EquipmentServiceImpl implements EquipmentService, AbstractLogger {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentConvertor equipmentConvertor;

    public EquipmentServiceImpl(
            EquipmentRepository equipmentRepository,
            EquipmentConvertor equipmentConvertor
    ) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentConvertor = equipmentConvertor;
    }

    @Override
    public Mono<EquipmentResponse> findByUuid(String uuid) {
        logger().info("Try to find out by uuid:" + uuid);
        return equipmentRepository.findByUuid(uuid)
                .switchIfEmpty(Mono.error(new EquipmentNotFoundException(uuid)))
                .map(equipmentConvertor::convertTo);
    }

    @Override
    public Flux<EquipmentResponse> findAll() {
        logger().info("find all");
        return equipmentRepository.findAll()
                .map(equipmentConvertor::convertTo);
    }

    @Override
    public Mono<String> create(CreateEquipmentRequest equipment) {
        logger().info("create new:" + equipment);
        var dto = equipmentConvertor.convertTo(equipment);
        return equipmentRepository.save(dto)
                .map(Equipment::uuid);
    }

}
