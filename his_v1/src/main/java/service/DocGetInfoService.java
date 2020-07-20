package service;

import com.alibaba.fastjson.JSON;
import dao.DiseaseMapper;
import dao.RegRecordMapper;
import entity.Disease;
import entity.RegRecord;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DocGetInfoService {
    public String getPatientJson(String name) {
        RegGetInfoService regGetInfoService = new RegGetInfoService();
        int docId = regGetInfoService.getUserIdByName(name);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(new Date());

        String json = null;

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            List<RegRecord> regRecords = regRecordMapper.getRegRecords(docId, today);
            json = JSON.toJSONString(regRecords);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return json;
    }


    public String getDiseaseJson(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            Disease disease = diseaseMapper.getDiseaseByName(name);
            json = JSON.toJSONString(disease);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }

}
