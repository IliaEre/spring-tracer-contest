package com.ere.psc.orderapi.model;

public record Equipment(
        String uuid,
        String code,
        String name,
        String size,
        String quality,
        String status
) { }
