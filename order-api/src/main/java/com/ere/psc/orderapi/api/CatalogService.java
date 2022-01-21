package com.ere.psc.orderapi.api;

public interface CatalogService<T> {
    T findEquipmentById(String id);
}
