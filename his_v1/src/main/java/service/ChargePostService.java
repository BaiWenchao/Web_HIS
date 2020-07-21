package service;

import dao.ChargeInfoMapper;
import dao.InvoiceMapper;
import entity.ChargeInfo;
import entity.Invoice;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChargePostService {
    public void insertInvoice(int invoiceNum, float invoiceAmt, float invoiceRealGet, float invoiceBalance,  int regId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String today = df.format(date);
        try {
            InvoiceMapper invoiceMapper = sqlSession.getMapper(InvoiceMapper.class);
            Invoice invoice = new Invoice(0, invoiceNum, invoiceAmt, invoiceRealGet, invoiceBalance, 1, today, 9, regId);
            int res = invoiceMapper.insertInvoice(invoice);

            if (res>0) {
                System.out.println("success!");
                sqlSession.commit();
            }
        } catch (Exception e) {
            System.out.println("failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void updateStatus(int idx, String status) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
            int res = chargeInfoMapper.updateStatus(status, idx);
            if (res > 0) {
                System.out.println("success");
                sqlSession.commit();
            }
        } catch (Exception e) {
            System.out.println("failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
