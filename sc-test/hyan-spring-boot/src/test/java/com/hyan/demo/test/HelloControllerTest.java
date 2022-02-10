package com.hyan.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO
 *
 * @author yanhanf
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/index");
    }

    @Test
    public void getHello() {
        System.out.println("请求地址为:" + this.base.toString());
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        System.out.println("hello spring".equals(response.getBody()));
    }
}
