package com.ere.psc.equipmentapi.domain.exception;

import java.util.Objects;

public class EquipmentNotFoundException extends RuntimeException {

    private String message;

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentNotFoundException that = (EquipmentNotFoundException) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
