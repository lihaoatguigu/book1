package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用userServcie.login():User检查用户登录
        User loginUser = userService.login(new User(null, username, password, null));
        // 根据login的返回结果判定用户是否登录成功
        if (loginUser == null) {
            System.out.println(username + " , 用户登录失败");
            // 登录失败
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        } else {
            // 登录成功
            System.out.println(username + " , 用户登录成功");

            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }

    }

}
