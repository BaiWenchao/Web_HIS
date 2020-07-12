package dao;

import entity.Patient;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class PatientMapperTest {
    @Test
    public void getPatientByID() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            Patient patient = patientMapper.getPatientById(1);
            System.out.println(patient);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
