package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class ConstantItemMapperTest {
    @Test
    public void getUserCate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            ConstantItemMapper constantItemMapper = sqlSession.getMapper(ConstantItemMapper.class);
            System.out.println(constantItemMapper.getConstantItemById(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
