package com.jzjr.kafkademo.consumer;

import com.jzjr.kafkademo.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AGIConsumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @KafkaListener(topics = "${agi.topic}", groupId = "agi-groups")
    public void onMessage(String message) {
        logger.info("[onMessage][线程编号：{},消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
