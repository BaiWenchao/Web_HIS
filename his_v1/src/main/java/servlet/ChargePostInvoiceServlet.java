package servlet;

import com.alibaba.fastjson.JSONObject;
import service.ChargePostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChargePostInvoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hhh");

        int invoiceNum = Integer.parseInt(req.getParameter("invoiceNum"));
        float invoiceAmt = Float.parseFloat(req.getParameter("invoiceAmt"));
        float invoiceRealGet = Float.parseFloat(req.getParameter("invoiceRealGet"));
        float invoiceBalance = Float.parseFloat(req.getParameter("invoiceBalance"));
        int regId = Integer.parseInt(req.getParameter("regId"));
        String arr = req.getParameter("arr");

        List<Integer> idxArr = JSONObject.parseArray(arr, Integer.class);

        ChargePostService chargePostService = new ChargePostService();
        chargePostService.insertInvoice(invoiceNum, invoiceAmt, invoiceRealGet, invoiceBalance, regId);

        // 循环改变状态:
        for (int i : idxArr) {
            chargePostService.updateStatus(i, "已缴费");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
