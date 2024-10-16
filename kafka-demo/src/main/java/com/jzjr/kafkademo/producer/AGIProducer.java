package com.jzjr.kafkademo.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;

@Component
public class AGIProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value(value = "${agi.topic:quickstart-events}")
    private  String topic;

    public AGIProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void asyncSend(String message) {
        //KafkaTemplate的send方法是异步的，异常处理不要使用try-catch，使用回调函数来处理
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);
        // 添加回调来处理发送结果,whenComplete在异步操作完成时执行，无论成功或失败
        future.whenComplete((sendResult, throwable) -> {
            if (throwable == null) {
                // 消息发送成功
                handleSuccess(sendResult, message);
            } else {
                // 消息发送失败
                handleFailure(throwable, message);
            }
        });
    }

    private void handleSuccess(SendResult<String, Object> sendResult, String message) {
        // 处理成功发送的逻辑，例如记录日志或更新状态
        String receiveTopic = sendResult.getProducerRecord().topic();
        Integer partition = sendResult.getProducerRecord().partition();
        System.out.println("Message sent successfully: " + message + "\n receiveTopic: " + receiveTopic + "\n partition: " + partition);
        // 您可以访问 sendResult 来获取更多信息，如分区号、偏移量等
    }

    private void handleFailure(Throwable throwable, String message) {
        // 处理发送失败的逻辑，例如记录错误或重试发送
        System.err.println("Failed to send message: " + message);
        System.out.println(throwable.getMessage());;
    }
}
