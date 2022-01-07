package com.ere.psc.orderapi.service.external.model;

import com.ere.psc.orderapi.api.CatalogService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CatalogWebService implements CatalogService {

    @Override
    public Optional findEquipmentById(String id) {
        // TODO: integration with go servie
        return Optional.empty();
    }
}
