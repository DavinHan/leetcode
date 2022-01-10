package com.hyan.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 调用
 *
 * @author yanhanf
 */
@Slf4j
@RestController
public class DcController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/vendor")
    public String dc2() {
        return restTemplate.getForObject("http://manufacturers/dc", String.class);
    }
}
