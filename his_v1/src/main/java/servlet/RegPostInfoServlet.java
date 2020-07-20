package servlet;

import entity.Patient;
import entity.RegRecord;
import service.PatientWriteInfoService;
import service.RegGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegPostInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        // 获取信息：
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String birthday = req.getParameter("birthday");
        int gender = Integer.parseInt(req.getParameter("gender"));
        String idNum = req.getParameter("idNum");
        String address = req.getParameter("address");
        int feeType = (req.getParameter("feeType").equals("自费")) ? 1 : 2;
        String date = req.getParameter("date");
        String regNoon = req.getParameter("regNoon");
        int dept = (req.getParameter("dept").equals("心血管内科")) ? 1 : 2;
        int regLevel = (req.getParameter("regLevel").equals("专家号")) ? 1 : 2;
        String doctor = req.getParameter("doctor");
        int needBook = Integer.parseInt(req.getParameter("needBook"));
        int payType = (req.getParameter("payType").equals("微信")) ? 23 : 24;
        int patientId = 0;


        // 判断是否初次挂号：
        RegGetInfoService regGetInfoService = new RegGetInfoService();
        Patient p = regGetInfoService.getPatientByName(name);
        PatientWriteInfoService patientWriteInfoService = new PatientWriteInfoService();
        if(p == null) {
            // 先注册
            patientWriteInfoService.insertPatient(0, name, gender, idNum, birthday, address);
            Patient newPatient = regGetInfoService.getPatientByName(name);
            patientId = newPatient.getId();
        } else {
            patientId = p.getId();
        }

        int docId = regGetInfoService.getUserIdByName(doctor);


        RegRecord regRecord = new RegRecord(0, patientId, name, gender, age, date, regNoon, dept, docId, regLevel, feeType, needBook, 9, 1, payType);
        // 将患者插入列表：
        patientWriteInfoService.insertRegRecord(regRecord);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
