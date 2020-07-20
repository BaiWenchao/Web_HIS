package servlet;

import entity.RegInfo;
import service.DocWriteInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DocPostInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String diseases = req.getParameter("diseaseInfo");
        String name = req.getParameter("name");
        int regId = Integer.parseInt(req.getParameter("regId"));
        String selfComplaint = req.getParameter("selfComplaint");
        String currentHistory = req.getParameter("currentHistory");
        String currentStatus = req.getParameter("currentStatus");
        String pastHistory = req.getParameter("pastHistory");
        String allergyHistory = req.getParameter("allergyHistory");
        String bodyCheck = req.getParameter("bodyCheck");

        // 插入数据
        RegInfo regInfo = new RegInfo(0, regId, selfComplaint, currentHistory, currentStatus, pastHistory, allergyHistory, bodyCheck);
        DocWriteInfoService docWriteInfoService = new DocWriteInfoService();
        docWriteInfoService.insertRegInfo(regInfo);
        docWriteInfoService.insertDiagnoseInfo(regId, diseases);

        // 更新患者挂号状态
        docWriteInfoService.updateRegStatus(regId, 2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
