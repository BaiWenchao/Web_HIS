package servlet;

import com.alibaba.fastjson.JSON;
import entity.ConstantType;
import entity.Patient;
import service.RegGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegGetPatientInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String patientName = req.getParameter("patientName");

        RegGetInfoService regGetInfoService = new RegGetInfoService();
        Patient patient = regGetInfoService.getPatientByName(patientName);

        if (patient != null) {
            String patientJson = regGetInfoService.getPatientJSON(patient);
            resp.getWriter().print(patientJson);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
