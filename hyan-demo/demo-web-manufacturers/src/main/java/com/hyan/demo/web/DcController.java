package com.hyan.demo.web;

import com.google.gson.Gson;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 工厂
 *
 * @author yanhanf
 */
@RestController
public class DcController {

    @Resource
    private DiscoveryClient discoveryClient;

    private static final Gson gson = new Gson();

    @GetMapping("/dc")
    public String dc() {
        return gson.toJson(discoveryClient.getServices());
    }
}
