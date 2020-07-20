package service;

import com.alibaba.fastjson.JSON;
import dao.*;
import entity.Patient;
import entity.RegRecord;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RegGetInfoService {

    public Patient getPatientByName(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Patient patient = new Patient();
        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            patient = patientMapper.getPatientByName(name);

            ConstantItemService constantItemService = new ConstantItemService();
            String gender = constantItemService.getConstantItemNameById(patient.getPatientGender());
            patient.setReadableGender(gender);

            Date date = new Date();
            int age = (int) ((date.getTime() - patient.getBirthday().getTime())/(1000*60*60*24))/365;
            patient.setAge(age);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return patient;
    }




    public String getPatientJSON(Patient patient) {
        return JSON.toJSONString(patient);
    }

    public List<String> getDocName(String dept, String regLevel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        List<String> userName = null;
        try {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            int deptId = departmentMapper.getDeptId(dept);

            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            int regLevelId = regLevelMapper.getRegLevelId(regLevel);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userName = userMapper.getUserName(deptId, regLevelId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return userName;
    }

    public String getDocNameJson(List<String> docs) {
        return JSON.toJSONString(docs);
    }

    public int getRegLimit(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int regLimit = 0;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserByRealName(name);

            int level = user.getRegLevel();

            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            regLimit = regLevelMapper.getRegLimit(level);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return regLimit;
    }

    public int getRegConsume(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        int count = 0;
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String today = df.format(date);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserByRealName(name);
            int id = user.getId();

            count = regRecordMapper.getRegCount(id, today);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return count;
    }

    public String getFeeJson() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String json = null;
        try {
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            List<Integer> list = regLevelMapper.getFee();

            json = JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }

    public int getUserIdByName(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int id = 0;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            id = userMapper.getUserId(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return id;
    }


    public String getPatientById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Patient patient = new Patient();
        String json = null;
        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            patient = patientMapper.getPatientById(id);

            ConstantItemService constantItemService = new ConstantItemService();
            String gender = constantItemService.getConstantItemNameById(patient.getPatientGender());
            patient.setReadableGender(gender);

            Date date = new Date();
            int age = (int) ((date.getTime() - patient.getBirthday().getTime())/(1000*60*60*24))/365;
            patient.setAge(age);

            json = JSON.toJSONString(patient);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }

    public String getRegRecrdById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        RegRecord regRecord = new RegRecord();
        String json = null;
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            regRecord = regRecordMapper.getRegRecord(id);

            json = JSON.toJSONString(regRecord);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return json;
    }



}
