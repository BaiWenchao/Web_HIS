package service;

import dao.PatientMapper;
import dao.RegRecordMapper;
import entity.Patient;
import entity.RegRecord;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientWriteInfoService {
    public void insertPatient(int id, String name, int gender, String idNumber, String birthday, String address) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            int res = patientMapper.insertPatient(id, name, gender, idNumber, birthday, address);

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

    public void insertRegRecord(RegRecord regRecord) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            int res = regRecordMapper.insertRegRecord(regRecord);

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
