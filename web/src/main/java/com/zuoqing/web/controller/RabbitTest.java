package com.zuoqing.web.controller;

import com.zuoqing.web.config.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaomin on 2017/12/4.
 */
@RestController
@RequestMapping(value = "rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender helloSender1;
    @Autowired
    private HelloSender helloSender2;

    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}
