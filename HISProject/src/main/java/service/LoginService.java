package service;

import dao.UserMapper;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

public class LoginCheck {
    public void getUserByUserName(String userName, String pwd) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user;
        // 根据用户名获得医生对象
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getUserByUserName(userName);
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
