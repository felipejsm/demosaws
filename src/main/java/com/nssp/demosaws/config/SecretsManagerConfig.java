package com.nssp.demosaws.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;

import java.net.URI;

@ConfigurationProperties("secretsmanager")
@Data
public class SecretsManagerConfig {
    private URI endpointURI;
    private Region region;
    private String secretName;
}
