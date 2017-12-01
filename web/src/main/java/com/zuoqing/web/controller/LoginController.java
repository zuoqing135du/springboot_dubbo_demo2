package com.zuoqing.web.controller;

import com.zuoqing.base.entity.Girl;
import com.zuoqing.base.entity.User;
import com.zuoqing.web.redis.RedisService;
import com.zuoqing.web.service.LoginConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zuoqing on 2017/11/21.
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    LoginConsumerService loginService;


    @RequestMapping(value = "login")
    public Object login(){
        loginService.login();
        return   "11122333444";
    }

    @RequestMapping(value = "findUser")
    public User findUser(){

        return loginService.findUser();
    }

//    @RequestMapping(value = "findUser2")
//    public User findUser2(){
//        return userService.findUser();
//    }
//
//    @RequestMapping(value = "findMenuList")
//    public Object findMenuList(){
//        return userService.findMenuList();
//    }

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String redisTest() {

        List<Girl> list = new ArrayList();
        Girl girl = new Girl();
        girl.setCupSize("C");
        girl.setAge(30);
        list.add(girl);
        redisService.set("girlList",list);

        StringBuffer sb = new StringBuffer();
        redisService.set("str", "str");
        sb.append("str=").append(redisService.get("str").toString()).append(",");
        redisService.hmSet("hmset", "key", "val");
        sb.append("hmset=").append(redisService.hmGet("hmset", "key")).append(",");
        redisService.lPush("list", "val");
        sb.append("list=").append(redisService.lRange("list", 0, 1).toString()).append(",");
        redisService.add("set", "val");
        sb.append("set=").append(redisService.setMembers("set").toString()).append(",");
        redisService.zAdd("zset", "val1", 1);
        redisService.zAdd("zset", "val2", 2);
        sb.append("zset=").append(redisService.rangeByScore("zset", 1, 2)).append(",");

        return sb.toString();
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public String redisTest2() {
        StringBuffer sb = new StringBuffer();
        redisService.set("str", "str");
        sb.append("str=").append(redisService.get("str").toString()).append(",");
        redisService.hmSet("hmset", "key", "val");
        sb.append("hmset=").append(redisService.hmGet("hmset", "key")).append(",");
        redisService.lPush("list", "val");
        sb.append("list=").append(redisService.lRange("list", 0, 1).toString()).append(",");
        redisService.add("set", "val");
        sb.append("set=").append(redisService.setMembers("set").toString()).append(",");
        redisService.zAdd("zset", "val1", 1);
        redisService.zAdd("zset", "val2", 2);
        sb.append("zset=").append(redisService.rangeByScore("zset", 1, 2)).append(",");
        return sb.toString();
    }


}
