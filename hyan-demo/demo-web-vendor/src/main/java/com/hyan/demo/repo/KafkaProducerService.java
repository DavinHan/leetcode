package com.hyan.demo.repo;

import java.util.concurrent.ExecutionException;

/**
 * @author yanhanf
 * @ClassName KafkaProducerService
 * @Description TODO
 * @Date 2021/11/24
 */
public interface KafkaProducerService {

    String makeOrder(String user, int goods, int price) throws ExecutionException, InterruptedException;
}
