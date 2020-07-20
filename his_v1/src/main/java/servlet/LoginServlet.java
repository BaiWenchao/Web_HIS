package servlet;

import entity.User;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        User user = loginService.getUser(login, password);


        if (user != null) {
            String cate = loginService.getUserCate(user.getUserCate());

            if (cate.equals("发药员")) {
                // 发药员
                req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
                resp.sendRedirect(req.getContextPath() + "/pharmacyPage.jsp");
            } else if(cate.equals("管理员")) {
                // 管理员
                req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
                resp.sendRedirect(req.getContextPath() + "/adminPage.jsp");
            } else if(cate.equals("挂号收费员")) {
                // 挂号员
                req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
                resp.sendRedirect(req.getContextPath() + "/registrarPage.jsp");
            } else {
                // 医生
                req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
                resp.sendRedirect(req.getContextPath() + "/doctorPage.jsp");
            }
            // 存入用户名
            req.getServletContext().setAttribute("userName", user.getRealName());
        } else {
            // 重新跳转到登录界面
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
