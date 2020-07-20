package servlet;

import service.ChargePostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChargePostInvoiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println();

        int invoiceNum = Integer.parseInt(req.getParameter("invoiceNum"));
        float invoiceAmt = Float.parseFloat(req.getParameter("invoiceAmt"));
        float invoiceRealGet = Float.parseFloat(req.getParameter("invoiceRealGet"));
        float invoiceBalance = Float.parseFloat(req.getParameter("invoiceBalance"));
        int regId = Integer.parseInt("regId");


        ChargePostService chargePostService = new ChargePostService();
        chargePostService.insertInvoice(1001, 20, 30, 10, 1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
