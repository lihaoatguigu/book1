package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        User loginUser = userService.login(new User(null, "sdy", "123456", null));
        if (loginUser == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("sdy6890")) {
            System.out.println("用户名不可用");
        } else {
            System.out.println("用户名可用");
        }
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null, "hhl", "666666", "hhl@atguigu.com"));
    }
}