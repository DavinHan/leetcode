//package com.hyan.demo.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author yanhanf
// * @ClassName KafkaConfiguration
// * @Description TODO
// * @Date 2021/11/23
// */
//@Configuration
//public class KafkaConfiguration {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String kafkaBootstrapServers;
//
//    /**
//     * 构建消费者属性的map
//     * @return
//     */
//    private Map<String, Object> consumerProperties() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
//        return props;
//    }
//
//    @Bean("consumerFactory")
//    public ConsumerFactory consumerFactory() {
//        return new DefaultKafkaConsumerFactory(consumerProperties());
//    }
//}
