package com.huzaifabilal.BookStoreService.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;
    @Value("${aws.dynamodb.accessKey}")
    private String awsAccessKey;
    @Value("${aws.dynamodb.secretKey}")
    private String awsSecretKey;



    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(amazonDynamoDB());
    }


    private AmazonDynamoDB amazonDynamoDB() {

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint,"us-east-2"))
                .withCredentials(amazonDynamoDBCredentials())
                .build();
    }

    private AWSCredentialsProvider amazonDynamoDBCredentials () {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,awsSecretKey));
    }


}
