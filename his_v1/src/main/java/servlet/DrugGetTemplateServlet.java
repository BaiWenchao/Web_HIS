package servlet;

import service.DrugGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DrugGetTemplateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String templateName = req.getParameter("templateName");

        DrugGetInfoService drugGetInfoService = new DrugGetInfoService();
        String templateJson = drugGetInfoService.getTemplateJson(templateName);

        resp.getWriter().print(templateJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
