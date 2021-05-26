package com.nssp.demosaws;

import com.nssp.demosaws.config.SecretsManagerConfig;
import com.nssp.demosaws.secretsmanager.GetSecretValue;
import com.nssp.demosaws.secretsmanager.IGetSecretValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/v1")
@EnableConfigurationProperties(SecretsManagerConfig.class)
public class DemosAwsApplication {

    private IGetSecretValue secretValue;

    public DemosAwsApplication(IGetSecretValue secretValue) {
        this.secretValue = secretValue;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemosAwsApplication.class, args);
    }


    @GetMapping("/secrets")
    public String get() {
        return secretValue.getValue();
    }
}
