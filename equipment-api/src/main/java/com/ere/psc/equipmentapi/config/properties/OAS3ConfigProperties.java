package com.ere.psc.equipmentapi.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("apidoc")
public record OAS3ConfigProperties(
    String title,
    String description,
    String version
) {}
