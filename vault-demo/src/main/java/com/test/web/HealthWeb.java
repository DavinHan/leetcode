package com.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求测试
 *
 * @author yanhanf
 */
@RestController
public class HealthWeb {

    @GetMapping("/health")
    public String health(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        String key;
        while(headerNames.hasMoreElements()) {
            map.put((key = headerNames.nextElement()), request.getHeader(key));
        }
        return "ok,headers is :" + map.toString();
    }
}
