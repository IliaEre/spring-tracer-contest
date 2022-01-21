package com.ere.psc.equipmentapi.service.mapper;

import com.ere.psc.equipmentapi.model.entity.Equipment;
import com.ere.psc.equipmentapi.model.request.CreateEquipmentRequest;
import com.ere.psc.equipmentapi.model.response.EquipmentResponse;
import org.springframework.stereotype.Component;

@Component
public class EquipmentConvertor {

    public Equipment convertTo(CreateEquipmentRequest createEquipmentRequest) {
        return new Equipment(
                null,
                createEquipmentRequest.uuid(),
                createEquipmentRequest.code(),
                createEquipmentRequest.name(),
                createEquipmentRequest.size(),
                createEquipmentRequest.quality()
        );
    }

    public EquipmentResponse convertTo(Equipment equipment) {
        return new EquipmentResponse(
                equipment.uuid(),
                equipment.code(),
                equipment.name(),
                equipment.size(),
                equipment.quality()
        );
    }

}
