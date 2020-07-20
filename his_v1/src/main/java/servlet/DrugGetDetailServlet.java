package servlet;

import service.DrugGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DrugGetDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int templateId = Integer.parseInt(req.getParameter("templateId"));

        DrugGetInfoService drugGetInfoService = new DrugGetInfoService();
        String json = drugGetInfoService.getTemplateDetailJson(templateId);

        resp.getWriter().print(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }



}
