package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * existsUsername  ==>>> exists是否存在 , Username用户名
     *
     * 判断用户名是否存在
     * @param username  查询的用户名
     * @return false表示不存在,也就是可用 <br>
     *     true表示存在,用户名不可用
     */
    public boolean existsUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

}
