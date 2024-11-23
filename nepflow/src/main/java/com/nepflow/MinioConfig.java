package com.nepflow;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class MinioConfig {
    @Value("${minio.url}")
    private String url;

    @Value("${minio.port}")
    private int port;

    @Value("${minio.secure}")
    private boolean isSecure;

    @Value("${minio.access.name}")
    private String accessKey;

    @Value("${minio.access.secret}")
    private String accessSecret;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url, port, isSecure)
                .credentials(accessKey, accessSecret)
                .build();
    }


}

