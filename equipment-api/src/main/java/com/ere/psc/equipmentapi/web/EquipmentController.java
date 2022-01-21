package com.ere.psc.equipmentapi.web;

import com.ere.psc.equipmentapi.model.request.CreateEquipmentRequest;
import com.ere.psc.equipmentapi.model.response.CreatedResponse;
import com.ere.psc.equipmentapi.model.response.EquipmentResponse;
import com.ere.psc.equipmentapi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(@Qualifier("EquipmentServiceFacade") EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public Flux<EquipmentResponse> getAll() {
        return equipmentService.findAll();
    }

    @GetMapping("/{uuid}")
    public Mono<EquipmentResponse> get(@PathVariable("uuid") String uuid) {
        return equipmentService.findByUuid(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreatedResponse> create(@RequestBody @Validated CreateEquipmentRequest equipment) {
        return equipmentService.create(equipment)
                .map((it) -> new CreatedResponse(it, "ok"));
    }

}
