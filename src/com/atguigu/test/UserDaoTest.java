package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null, "sdy", "123456", "wzg168@qq.com"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        // 登录操作
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("用户名或密码错误,登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void queryUserByUsername() {
        // 查询用户名是否可用
        User existsUser = userDao.queryUserByUsername("wzg1682345");
        if (existsUser == null) {
            System.out.println("用户名可用!");
        } else {
            System.out.println("用户名不可用!");
        }
    }

    @Test
    public void test3(){
        for (User user : userDao.queryUsers()) {
            System.out.println(user);
        }
    }


}