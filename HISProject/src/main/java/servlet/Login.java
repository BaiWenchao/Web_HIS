package servlet;

import entity.User;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        User user = loginService.getUser(login, password);

        if (user != null) {

            if (user.getUserCate() == 1) {
                // 发药员
                resp.sendRedirect(req.getContextPath() + "/pharmacy.jsp");
            } else if(user.getUserCate() == 2) {
                // 管理员
                resp.sendRedirect(req.getContextPath() + "/admin.jsp");
            } else if(user.getUserCate() == 3) {
                // 挂号员
                resp.sendRedirect(req.getContextPath() + "/registrar.jsp");
            } else {
                // 医生
                resp.sendRedirect(req.getContextPath() + "/doctor.jsp");
            }
        } else {
            System.out.println("用户名或密码有误！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}