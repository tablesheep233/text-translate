package com.github.tablesheep233.text.translate.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return restTemplate -> {
            OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
            factory.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(30L));
            factory.setReadTimeout((int) TimeUnit.SECONDS.toMillis(30L));
            factory.setWriteTimeout((int) TimeUnit.SECONDS.toMillis(30L));
            restTemplate.setRequestFactory(factory);
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
