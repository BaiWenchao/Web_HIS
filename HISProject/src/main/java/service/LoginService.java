package service;

import dao.UserMapper;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

public class LoginService {
    public User getUser(String userName, String pwd) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        // 根据用户名获得医生对象
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getUserByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        // 判断用户名是否存在
        if (user != null) {
            // 判断用户名和密码是否匹配
            if (user.getPwd().equals(pwd)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
