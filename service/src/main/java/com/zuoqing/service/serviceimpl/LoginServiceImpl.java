package com.zuoqing.service.serviceimpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.zuoqing.base.LoginService;
import com.zuoqing.base.dao.MenuMapper;
import com.zuoqing.base.entity.Menu;
import com.zuoqing.base.entity.MenuExample;
import com.zuoqing.base.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zuoqing on 2017/11/22.
 */
@Service(version = "1.0.0")
public class LoginServiceImpl implements LoginService {

    @Autowired
    MenuMapper menuDao;

    @Override
    public List<Menu> selectMenu() {
        System.out.print("1111111111111111111114");
        MenuExample example = new MenuExample();
        System.err.print(menuDao.select(example).size());
        System.out.print("4111111111111111111111"+"服务器2");
        example.setOrderByClause("qwer");
        return menuDao.select(example);
    }

    @Override
    public String login() {
        System.out.println("111111111111111111111/n");
        MenuExample example = new MenuExample();
//        System.err.print(menuDao.deleteByPrimaryKey(1));
        System.err.println(menuDao.selectByExample(example).get(1).getMenuId());
        return "111111111111111111111";
    }

    @Override
    public User findUser() {
        User user = new User();
        user.setName("刘德华");
        user.setAge(58);
        System.err.println("服务器1");

        return user;
    }

}
