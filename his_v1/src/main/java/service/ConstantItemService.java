package service;

import dao.ConstantItemMapper;
import dao.PatientMapper;
import entity.ConstantItem;
import entity.Patient;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.Date;

public class ConstantItemService {
    public String getConstantItemNameById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String itemName = null;
        try {
            ConstantItemMapper constantItemMapper = sqlSession.getMapper(ConstantItemMapper.class);
            itemName = constantItemMapper.getConstantItemById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return itemName;
    }
}
