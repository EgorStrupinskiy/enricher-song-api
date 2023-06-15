package com.innowise.songapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
public class SQSClientConfiguration {

    @Value("${aws.endpoint}")
    private String sqsEndpointUrl;
    @Value("${aws.region}")
    private String sqsRegion;

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .credentialsProvider(() -> AwsBasicCredentials.create(accessKey, secretKey))
                .region(Region.of(sqsRegion))
                .endpointOverride(URI.create(sqsEndpointUrl))
                .build();
    }

}
