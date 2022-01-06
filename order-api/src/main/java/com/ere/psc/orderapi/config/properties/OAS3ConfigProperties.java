package com.ere.psc.orderapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("apidoc")
public class OAS3ConfigProperties {

    private String title;
    private String description;
    private String version;

    public OAS3ConfigProperties() {}

    public OAS3ConfigProperties(String title, String description, String version) {
        this.title = title;
        this.description = description;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
