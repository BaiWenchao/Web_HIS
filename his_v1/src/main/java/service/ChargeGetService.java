package service;

import com.alibaba.fastjson.JSON;
import dao.ChargeInfoMapper;
import dao.PatientMapper;
import dao.RegRecordMapper;
import entity.ChargeInfo;
import entity.Patient;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

public class ChargeGetService {
    public String getPatient(int regId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            int id = regRecordMapper.getPatientId(regId);
            Patient p = patientMapper.getPatientById(id);
            json = JSON.toJSONString(p);
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return json;
    }


    public String getChargeInfo(int regId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
            List<ChargeInfo> list = chargeInfoMapper.getChargeInfoByRegId(regId);
            json = JSON.toJSONString(list);
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }


    public float calFee(List<Integer> idxArr) {
        float sum = 0;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
            for (int idx : idxArr) {
                sum += chargeInfoMapper.getFee(idx);
            }
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return sum;
    }

}
