package service;

import com.alibaba.fastjson.JSON;
import dao.ChargeInfoMapper;
import dao.DrugTemplateDetailMapper;
import dao.DrugTemplateMapper;
import entity.DrugTemplate;
import entity.DrugTemplateDetail;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugGetInfoService {
    public String getTemplateJson(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            DrugTemplateMapper drugTemplateMapper = sqlSession.getMapper(DrugTemplateMapper.class);
            DrugTemplate template = drugTemplateMapper.getTemplateByName(name);
            json = JSON.toJSONString(template);
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return json;
    }

    public String getTemplateDetailJson(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            DrugTemplateDetailMapper drugTemplateDetailMapper = sqlSession.getMapper(DrugTemplateDetailMapper.class);
            List<DrugTemplateDetail> list = new ArrayList<>();
            list = drugTemplateDetailMapper.getTemplateDetail(id);
            json = JSON.toJSONString(list);

        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }


    public void insertChargeInfo(String info, String name, String id) {
        String s[] = info.split(",");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DrugTemplateDetailMapper drugTemplateDetailMapper = sqlSession.getMapper(DrugTemplateDetailMapper.class);
        ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int regId = Integer.parseInt(id);
        String patientName = name;
        String openTime = df.format(day);
        String drugStatus = "已开立";

        try {
            for (String st: s) {
                int a = Integer.parseInt(st);
                List<DrugTemplateDetail> list = drugTemplateDetailMapper.getTemplateDetail(a);

                for (DrugTemplateDetail d : list) {
                    String itemName = d.getDrugName();
                    float itemPrice = d.getDrugPrice();
                    int amount = d.getDrugAmount();
                    int res = chargeInfoMapper.insertChargeInfo(0, regId, patientName, itemName, itemPrice, amount, openTime, drugStatus);

                    if (res > 0) {
                        System.out.println("success!");
                        sqlSession.commit();
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("insert chargeInfo failure!");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
