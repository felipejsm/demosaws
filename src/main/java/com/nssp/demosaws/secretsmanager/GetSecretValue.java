package com.nssp.demosaws.secretsmanager;


import com.nssp.demosaws.config.SecretsManagerConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClientBuilder;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

import java.net.URI;
import java.util.Optional;

@Service
public class GetSecretValue implements IGetSecretValue{

    private SecretsManagerConfig config;

    public GetSecretValue(SecretsManagerConfig config) {
        this.config = config;
    }
    @Override
    public String getValue() {
        SecretsManagerClientBuilder secretsManagerClientBuilder = SecretsManagerClient.builder();

        if(this.config.getEndpointURI() != null) {
            secretsManagerClientBuilder.endpointOverride(this.config.getEndpointURI());
        }

        SecretsManagerClient secretsManagerClient = secretsManagerClientBuilder
                .region(config.getRegion())
                .build();
        try {
            GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
                    .secretId(config.getSecretName())
                    .build();
            GetSecretValueResponse valueResponse = secretsManagerClient.getSecretValue(valueRequest);
            return valueResponse.secretString();
        } catch (SecretsManagerException exception) {

        }
        return "no key";
    }
}
