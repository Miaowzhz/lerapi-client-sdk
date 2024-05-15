package com.ler.lerapiclientsdk;

import com.ler.lerapiclientsdk.client.LerApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("lerapi.client")
@Data
@ComponentScan
public class LerApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public LerApiClient lerApiClient() {
        return new LerApiClient(accessKey, secretKey);
    }
}
