package se.sundsvall.contractloader.integration.contract.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("integration.contract")
public record ContractProperties(int connectTimeout, int readTimeout) {}
