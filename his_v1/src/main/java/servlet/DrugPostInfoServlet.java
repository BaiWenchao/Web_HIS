package servlet;

import service.DocWriteInfoService;
import service.DrugGetInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DrugPostInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("info");
        String regId = req.getParameter("patientRegId");
        String name = req.getParameter("patientName");

        DrugGetInfoService drugGetInfoService = new DrugGetInfoService();
        drugGetInfoService.insertChargeInfo(str, name, regId);

        // 更新患者挂号状态：4（结束）
        int registerId = Integer.parseInt(regId);

        DocWriteInfoService docWriteInfoService = new DocWriteInfoService();
        docWriteInfoService.updateRegStatus(registerId, 4);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
