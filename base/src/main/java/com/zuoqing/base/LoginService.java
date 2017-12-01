package com.zuoqing.base;

import com.zuoqing.base.entity.Menu;
import com.zuoqing.base.entity.User;

import java.util.List;

/**
 * Created by zuoqing on 2017/11/22.
 */
public interface LoginService {

    List<Menu> selectMenu();

    String login();

    User findUser();


}
