package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    // UserService需要UserDao,后面专业的叫法,又叫依赖
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        User user = userDao.queryUserByUsername(username);

        if (user == null) {
            // 用户名可用
            return false;
        }
        // 不可用
        return true;

    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }
}
