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

@WebServlet(name = "RegistServlet", value = "/regist")
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        1 获取表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        // 假设验证码必须是:abcde.
        //        2 检查验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
//        3 检查用户名是否可用
            if (userService.existsUsername(username)) {
                //        用户名不可用
                System.out.println("用户名[" + username + "]已存在!");
                //        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);

            } else {
                //        用户名可用
                //        保存用户信息
                userService.registUser(new User(null,username,password,email));
                //                跳到注册成功页面
                //        regist_success.html
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
            }
        } else {
//                验证码错误
            System.out.println("验证码 [" + code + "] 错误!");
//        跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
        }

    }

}
