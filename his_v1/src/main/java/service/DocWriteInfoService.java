package service;

import dao.DiagnoseMapper;
import dao.RegInfoMapper;
import dao.RegRecordMapper;
import entity.RegInfo;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

public class DocWriteInfoService {
    public void insertRegInfo(RegInfo regInfo) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegInfoMapper regInfoMapper = sqlSession.getMapper(RegInfoMapper.class);
            int res = regInfoMapper.insertRegInfo(regInfo);
            if (res > 0) {
                System.out.println("success");
                sqlSession.commit();
            }
        } catch (Exception e) {
            System.out.println("reginfo failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void insertDiagnoseInfo(int regId, String diagnoseInfo) {
        String s[] = diagnoseInfo.split(",");
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DiagnoseMapper diagnoseMapper = sqlSession.getMapper(DiagnoseMapper.class);

        try {
            for (int i=0; i<s.length; i++) {

                int res = diagnoseMapper.insertDiagnose(regId, s[i]);

                if (res > 0) {
                    System.out.println("success");
                    sqlSession.commit();
                }
            }
        } catch (Exception e) {
            System.out.println("diag failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void updateRegStatus(int regId, int status) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            int res = regRecordMapper.updateRegRecord(regId, status);

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
