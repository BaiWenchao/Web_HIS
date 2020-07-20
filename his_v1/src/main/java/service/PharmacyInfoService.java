package service;

import com.alibaba.fastjson.JSON;
import dao.ChargeInfoMapper;
import entity.ChargeInfo;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;
import java.util.List;

public class PharmacyInfoService {
    public String getChargeInfoJson(int id){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
            List<ChargeInfo> list = chargeInfoMapper.getDeliveredInfo(id);
            json = JSON.toJSONString(list);
        } catch (Exception e) {
            System.out.println("pharmacy failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }
}
