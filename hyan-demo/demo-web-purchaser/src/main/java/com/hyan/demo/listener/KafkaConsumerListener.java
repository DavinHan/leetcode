package com.hyan.demo.listener;

import com.hyan.demo.constant.KafkaCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author yanhanf
 * @ClassName KafkaListener
 * @Description TODO
 * @Date 2021/11/23
 */
@Slf4j
//@Configuration
public class KafkaConsumerListener {

//    @KafkaListener(id = "hYanA", topics = KafkaCommon.KAFKA_TOPIC)
    public void consumerListener(String input){
        log.info("A接受到消息{}，进行消费", input);
    }
}
