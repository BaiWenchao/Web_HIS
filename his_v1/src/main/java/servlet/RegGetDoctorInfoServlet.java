package servlet;

import com.alibaba.fastjson.JSON;
import service.RegGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RegGetDoctorInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        try {
            String docName = req.getParameter("docName");

            RegGetInfoService regGetInfoService = new RegGetInfoService();
            int limit = regGetInfoService.getRegLimit(docName);
            int count = regGetInfoService.getRegConsume(docName);

            List<Integer> list = new ArrayList<>();

            list.add(limit);
            list.add(count);

            String json = JSON.toJSONString(list);
            resp.getWriter().print(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
