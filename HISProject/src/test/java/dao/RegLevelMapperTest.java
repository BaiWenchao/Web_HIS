package dao;

import entity.RegLevel;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class RegLevelMapperTest {
    @Test
    public void getRegLevel() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
//            UserCategoryMapper userCategoryMapper = sqlSession.getMapper(UserCategoryMapper.class);
//            String userCate = userCategoryMapper.getUserCate(1);
//            System.out.println(userCate);
            RegLevelMapper regLevelMapper = sqlSession.getMapper(RegLevelMapper.class);
            RegLevel regLevel = regLevelMapper.getRegLevelById(1);
            System.out.println(regLevel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
