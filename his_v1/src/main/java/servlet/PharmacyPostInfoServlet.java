package servlet;

import com.alibaba.fastjson.JSONObject;
import service.ChargePostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PharmacyPostInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arr = req.getParameter("data");
        List<Integer> idxArr = JSONObject.parseArray(arr, Integer.class);
        ChargePostService chargePostService = new ChargePostService();

        for (int i : idxArr) {
            chargePostService.updateStatus(i, "已取药");
        }

        resp.getWriter().print("发药成功！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
