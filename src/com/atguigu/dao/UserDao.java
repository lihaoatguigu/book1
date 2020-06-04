package com.atguigu.dao;

import com.atguigu.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * saveUser ===>>>>  save保存 , user用户 <br>
     *
     * 保存用户
     *
     * @param user 要保存的用户信息
     * @return 影响的行数
     */
    public int saveUser(User user);

    /**
     * queryUserByUsernameAndPassword   <br>
     *     query查询,
     *     User用户,
     *     By由...经...,
     *     Username用户名,
     *     And和并且的意思,
     *     Password密码
     *
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * queryUserByUsername   <br>
     *     query查询,
     *     User用户,
     *     By由...经...,
     *     Username用户名,
     *
     *
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 查询到的用户
     */
    public User queryUserByUsername(String username);

    /**
     * queryUsers ==>>> query查询, Users用户的复数,也就是多个用户
     *
     * 仅供测试
     * @return
     */
    public List<User> queryUsers();

}
