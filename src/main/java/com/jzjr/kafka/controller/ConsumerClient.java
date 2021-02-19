package com.jzjr.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerClient {
 @KafkaListener(topics="secret")
    public void listen(String msg){
     System.out.println("receive message is:");
     System.out.println(msg);
 }

}
