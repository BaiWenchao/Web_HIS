package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class UserCateMapperTest {
    @Test
    public void getUserCate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            UserCategoryMapper userCategoryMapper = sqlSession.getMapper(UserCategoryMapper.class);
            String userCate = userCategoryMapper.getUserCate(1);
            System.out.println(userCate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
