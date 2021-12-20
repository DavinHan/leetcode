package com.hyan.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yanhanf
 * @ClassName KafkaProducerTest
 * @Description TODO
 * @Date 2021/11/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testSend() {
        kafkaTemplate.send("hYan", 0, "test", "test1");
//        kafkaTemplate.send("hYan", 0, "test", "test2");
    }
}
