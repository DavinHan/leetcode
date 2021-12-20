package com.hyan.demo.repo.Impl;

import com.hyan.demo.constant.KafkaCommon;
import com.hyan.demo.repo.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author yanhanf
 * @ClassName KafkaProducerServiceImpl
 * @Description TODO
 * @Date 2021/11/24
 */
@Slf4j
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

//    @Resource
    private KafkaTemplate<String, Object> template;

    @Override
    public String makeOrder(String user, int goods, int price) throws ExecutionException, InterruptedException {
        String msg = String.format("生成订单，用户%s购买商品%d，其价格为%d，总共开销为%d", user, goods, price, price * goods);
        Map<String, String> msgMap = new HashMap<>();
        msgMap.put(user, msg);
        ListenableFuture<SendResult<String, Object>> sendResult = template.send(KafkaCommon.KAFKA_TOPIC, 0, "test", msgMap.toString());
        log.error("发送消息>>>>>{}", sendResult.get().getProducerRecord().toString());
        return msg;
    }
}
