package servlet;

import service.DocWriteInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeRegStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status = Integer.parseInt(req.getParameter("status"));
        int regId = Integer.parseInt(req.getParameter("regId"));

        DocWriteInfoService docWriteInfoService = new DocWriteInfoService();
        docWriteInfoService.updateRegStatus(regId, status);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
