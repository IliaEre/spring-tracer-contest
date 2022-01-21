package com.ere.psc.orderapi.service.external;

import com.ere.psc.orderapi.api.CatalogService;
import com.ere.psc.orderapi.config.ClassLogger;
import com.ere.psc.orderapi.model.Equipment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatalogWebService extends ClassLogger implements CatalogService<Equipment> {

    private final RestTemplate restTemplate;

    public CatalogWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Equipment findEquipmentById(String id) {
        var result = restTemplate.getForEntity("/v1/equipment/"+id, Equipment.class);
        logger.info("Web catalog result" + result);
        return result.getBody();
    }
}
