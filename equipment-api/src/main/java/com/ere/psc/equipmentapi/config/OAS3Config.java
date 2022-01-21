package com.ere.psc.equipmentapi.config;

import com.ere.psc.equipmentapi.config.properties.OAS3ConfigProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OAS3ConfigProperties.class)
public class OAS3Config {

    private final OAS3ConfigProperties oas3ConfigProperties;
    private static final String LICENSE = "Apache 2.0";

    public OAS3Config(OAS3ConfigProperties oas3ConfigProperties) {
        this.oas3ConfigProperties = oas3ConfigProperties;
    }

    @Bean
    public OpenAPI OrderOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(oas3ConfigProperties.title())
                        .description(oas3ConfigProperties.description())
                        .version(oas3ConfigProperties.version())
                        .license(new License().name(LICENSE)));
    }
}
