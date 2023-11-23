package com.yonyou.cloud.demo.web;

import com.yonyou.cloud.demo.client.IHyanServer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

    @Resource
    private IHyanServer server;

    @GetMapping("/say")
    @ResponseBody
    public String say(String name) {
        return server.sayHello(name);
    }
}
