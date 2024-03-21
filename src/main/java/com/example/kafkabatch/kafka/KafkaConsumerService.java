package com.example.kafkabatch.kafka;


import com.example.kafkabatch.model.entity.Customer;
import com.example.kafkabatch.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final CustomerService customerService;


    @KafkaListener(topics = "customer-topic", groupId = "my-group", concurrency = "12")
    public void listen(List<Customer> messages) {
        log.info("======== Size list: {} ========", messages.size());
        processMessagesBatch(messages);
    }

    public void processMessagesSingle(List<Customer> messages) {
        for (Customer c : messages) {
            log.info("Nome da thread: {}", Thread.currentThread().getName());
            customerService.save(c);
        }
    }
    //@Async()
    public void processMessagesBatch(List<Customer> messages) {
        log.info("Nome da thread: {}", Thread.currentThread().getName());
        customerService.save(messages);
    }

}
