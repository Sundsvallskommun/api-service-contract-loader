package se.sundsvall.contractloader.integration.estateinfo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("integration.estateinfo")
public record EstateInfoProperties(int connectTimeout, int readTimeout) {}
