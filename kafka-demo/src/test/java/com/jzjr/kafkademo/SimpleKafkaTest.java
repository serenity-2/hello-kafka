package com.jzjr.kafkademo;

import com.jzjr.kafkademo.producer.AGIProducer;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class SimpleKafkaTest {
    @Autowired
    private AGIProducer agiProducer;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        String message  = "The AGI will come in 2027~2030";
        agiProducer.asyncSend(message);
    }

    @Test
    public void test() {
        System.out.println("test");
    }

//    @Test
//    public void testASyncSend() throws InterruptedException {
//        int id = (int) (System.currentTimeMillis() / 1000);
//        producer.asyncSend(id).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
//            @Override
//            public void onFailure(Throwable e) {
//                logger.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
//            }
//
//            @Override
//            public void onSuccess(SendResult<Object, Object> result) {
//                logger.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, result);
//            }
//        });
//        // 阻塞等待，保证消费
//        new CountDownLatch(1).await();
//    }
}
