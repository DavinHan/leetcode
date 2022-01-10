package com.hyan.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @author yanhanf
 */
@FeignClient("manufacturers")
public interface DcService {

    @GetMapping("dc")
    String dc();
}
