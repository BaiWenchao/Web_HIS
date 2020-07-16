package dao;

import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

public class UserMapperTest {
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
}
