package com.hyan.demo.web;

import com.hyan.demo.repo.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author yanhanf
 * @ClassName KafkaProducerController
 * @Description TODO
 * @Date 2021/11/24
 */
@Slf4j
@RestController
@RequestMapping("/web/v1/purchase")
public class KafkaProducerController {

    @Resource
    private KafkaProducerService service;

    @RequestMapping("/goods")
    public String purchaseGoods(@RequestParam("user") String user,
                              @RequestParam("goods") int goods,
                              @RequestParam("price") int price) {
        try {
            return service.makeOrder(user, goods, price * 100);
        } catch (ExecutionException | InterruptedException e) {
            log.error("发送失败", e);
            return e.getMessage();
        }
    }
}
