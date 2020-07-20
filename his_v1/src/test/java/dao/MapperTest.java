package dao;

import com.alibaba.fastjson.JSON;
import entity.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import service.ChargePostService;
import service.DocWriteInfoService;
import service.RegGetInfoService;
import util.MyBatisUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {
    @Test
    public void getUserByUserName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserByUserName("bianque");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getPatientByName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            Patient patient = patientMapper.getPatientByName("李白");
            System.out.println(patient);
            String info = JSON.toJSONString(patient);

            Date date = new Date();
            int age = (int) ((date.getTime() - patient.getBirthday().getTime())/(1000*60*60*24))/365;
            System.out.println(age);

            patient.setAge(age);

            System.out.println(patient);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getConstantItemName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            ConstantItemMapper constantItemMapper = sqlSession.getMapper(ConstantItemMapper.class);
            String constantName = constantItemMapper.getConstantItemById(28);

            System.out.println(constantName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getRegLevel() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            List<String> regLevelList = regLevelMapper.getRegLevelList();

            for (String s: regLevelList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getFeeType() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            ConstantTypeMapper constantTypeMapper = sqlSession.getMapper(ConstantTypeMapper.class);
            int feeTypeId = constantTypeMapper.getConstantTypeIdByName("收费方式");

            ConstantItemMapper constantItemMapper = sqlSession.getMapper(ConstantItemMapper.class);
            List<String> feeTypeList = constantItemMapper.getConstantItemListByTypeId(feeTypeId);


            for (String s : feeTypeList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getFeeTypeList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            ConstantItemMapper constantItemMapper = sqlSession.getMapper(ConstantItemMapper.class);
            List<String> feeTypeList = constantItemMapper.getConstantItemListByTypeId(2);

            for (String s : feeTypeList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getDeptList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {


            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            List<String> deptList = departmentMapper.getDocDepts(4);

            for (String s : deptList) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserCateId() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserCategoryMapper userCategoryMapper = sqlSession.getMapper(UserCategoryMapper.class);
            System.out.println(userCategoryMapper.getUserCateId("医生"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getUserName() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<String> userName = userMapper.getUserName(2, 1);

            for (String s : userName) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getDeptId() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            System.out.println(departmentMapper.getDeptId("神经内科"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getRegLevelId() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            System.out.println(regLevelMapper.getRegLevelId("专家号"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getRegLimit() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            System.out.println(regLevelMapper.getRegLimit(1));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getRegCount() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String today = df.format(date);

            int count = regRecordMapper.getRegCount(1, today);

            System.out.println(count);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getRegFee() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            List<Integer> list = regLevelMapper.getFee();

            for (int i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertPatient() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            int res = patientMapper.insertPatient(0, "朱元璋", 27, "111111111", "2000-01-01", "安徽");

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

    @Test
    public void testUserId() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.getUserId("扁鹊"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void insertRegRecord() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecord regRecord = new RegRecord(0, 1, "李白", 27, 11, "2020-07-18", "上", 1, 1, 1, 1, 0, 9, 1, 24);
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

    @Test
    public void getRegRecords() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            List<RegRecord> regRecords = regRecordMapper.getRegRecords(1, "2020-07-18");
            for (RegRecord r : regRecords){
                System.out.println(r);
            }
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getDisease() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            System.out.println(diseaseMapper.getDiseaseByName("古典型霍乱"));
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void stringSplitTest() {
        String str = "伤寒,副伤寒,";
        String s[] = str.split(",");

        System.out.println(s.length);
    }

    @Test
    public void insertRegInfo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegInfoMapper regInfoMapper = sqlSession.getMapper(RegInfoMapper.class);
            RegInfo regInfo = new RegInfo(0, 1, "主诉", "现病史", "现病治疗情况", "既往史", "过敏史", "体格检查");
            int res = regInfoMapper.insertRegInfo(regInfo);

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

    @Test
    public void insertDiagnose() {
        String str = "伤寒,副伤寒,";
        String s[] = str.split(",");

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DiagnoseMapper diagnoseMapper = sqlSession.getMapper(DiagnoseMapper.class);
        try {
            for (int i=0; i<s.length; i++) {
                int res = diagnoseMapper.insertDiagnose(1, s[i]);

                if (res > 0) {
                    System.out.println("success");
                    sqlSession.commit();
                }
            }
        } catch (Exception e) {
            System.out.println("failure");
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void updateRegRecord() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            RegRecordMapper regRecordMapper = sqlSession.getMapper(RegRecordMapper.class);
            int res = regRecordMapper.updateRegRecord(1, 2);

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

    @Test
    public void getTemplate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            DrugTemplateMapper drugTemplateMapper = sqlSession.getMapper(DrugTemplateMapper.class);
            System.out.println(drugTemplateMapper.getTemplateByName("支气管哮喘"));
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getTemplateDetail() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            DrugTemplateDetailMapper drugTemplateDetailMapper = sqlSession.getMapper(DrugTemplateDetailMapper.class);
            List<DrugTemplateDetail> list = new ArrayList<>();
            list = drugTemplateDetailMapper.getTemplateDetail(1);

            for (DrugTemplateDetail d : list) {
                System.out.println(d);
            }
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getPatient() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            PatientMapper patientMapper = sqlSession.getMapper(PatientMapper.class);
            System.out.println(patientMapper.getPatientById(1));
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void getChargeInfo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
            List<ChargeInfo> list = chargeInfoMapper.getChargeInfoByRegId(1);

            for (ChargeInfo c : list) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testGetTemplate() {
        String str = "3,2,";
        String s[] = str.split(",");

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DrugTemplateDetailMapper drugTemplateDetailMapper = sqlSession.getMapper(DrugTemplateDetailMapper.class);
        try {
            for (String st: s) {
                int a = Integer.parseInt(st);
                List<DrugTemplateDetail> list = drugTemplateDetailMapper.getTemplateDetail(a);

                for (DrugTemplateDetail d : list) {
                    System.out.println(d);
                }
            }
        } catch (Exception e) {
            System.out.println("failure");
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void insertChargeInfo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ChargeInfoMapper chargeInfoMapper = sqlSession.getMapper(ChargeInfoMapper.class);
        try {
            int res = chargeInfoMapper.insertChargeInfo(0, 1, "李白", "测试药品", 15, 1, "2020--0-19 20:35:00", "已开立");
            if(res > 0) {
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

    @Test
    public void TestInvoice() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(date);
        try {
            InvoiceMapper invoiceMapper = sqlSession.getMapper(InvoiceMapper.class);
            Invoice invoice = new Invoice(0, 10001, 13, 15, 2, 1, today, 9, 1);
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


    @Test
    public void test() {
        ChargePostService chargePostService = new ChargePostService();
        chargePostService.insertInvoice(1001, 20, 30, 10, 1);
    }


    @Test
    public void getPatientById() {

    }
}
