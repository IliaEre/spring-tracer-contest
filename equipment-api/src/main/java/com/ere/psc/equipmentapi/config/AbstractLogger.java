package com.ere.psc.equipmentapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface AbstractLogger {
    default Logger logger() {
            return LoggerFactory.getLogger(this.getClass());
    }
}
