package com.zuoqing.web.controller;

import com.zuoqing.base.entity.User;
import com.zuoqing.web.service.LoginConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by zuoqing on 2017/11/21.
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    protected RedisTemplate<String,Object> redisTemplate;

    @Autowired
    LoginConsumerService loginService;

    @RequestMapping(value = "selectMenu")
    public Object selectMenu(){
        return loginService.selectMenu();
    }

    @RequestMapping(value = "selectMenuByRedis")
    public Object selectMenuByRedis(){
        List list = (List)redisTemplate.opsForValue().get("gymList");
        if(list==null){
            list = loginService.selectMenu();
            redisTemplate.opsForValue().set("gymList",list);
        }
        return list;
    }

    @RequestMapping(value = "login")
    public Object login(){
        loginService.login();
        return   "111";
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


}
