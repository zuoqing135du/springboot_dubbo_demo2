package com.zuoqing.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoqing.base.LoginService;
import com.zuoqing.base.entity.Menu;
import com.zuoqing.base.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zuoqing on 2017/11/23.
 */
@Component("LoginConsumerService")
public class LoginConsumerService implements LoginService {

    @Reference(version = "1.0.0")
    LoginService loginService;

    @Override
    public List<Menu> selectMenu() {
        return loginService.selectMenu();
    }

    @Override
    public String login() {
        loginService.login();
        return null;
    }

    @Override
    public User findUser() {
        return loginService.findUser();
    }
}
