package com.innowise.songapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Slf4j
@Component
@RequiredArgsConstructor
@RestController()
public class QueueListenerServiceImpl {
    private static final String QUEUE_URL = "http://localhost:4566/000000000000/song-api-queue";
    private final SqsClient sqsClient;

    @GetMapping("/get")
    public void get() {

        var receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(QUEUE_URL)
                .maxNumberOfMessages(10)
                .build();
        try {
            while (true) {
                var receiveResponse = sqsClient.receiveMessage(receiveRequest);
                var messages = receiveResponse.messages();
                if (!messages.isEmpty()) {
                    for (Message message : messages) {
                        var messageId = message.messageId();
                        var body = message.body();
                        log.info("Message received");
                        log.info("Message ID: " + messageId);
                        log.info("Message Body: " + body);
                        var deleteRequest = DeleteMessageRequest.builder()
                                .queueUrl(QUEUE_URL)
                                .receiptHandle(message.receiptHandle())
                                .build();
                        try {
                            sqsClient.deleteMessage(deleteRequest);
                        } catch (Exception e) {
                            log.error("Error while file processing");
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
