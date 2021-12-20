package com.hyan.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 调用
 *
 * @author yanhanf
 */
@RestController
public class DcController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/vendor")
    public String dc() {
        return restTemplate.getForObject("http://manufacturers/dc", String.class);
    }
}
