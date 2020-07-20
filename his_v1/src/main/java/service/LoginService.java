package service;

import dao.UserCategoryMapper;
import dao.UserMapper;
import entity.User;
import entity.UserCategory;
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

    public String getUserCate(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserCategory userCategory = new UserCategory();
        String cate = null;
        // 根据类别ID获取类别
        try {
            UserCategoryMapper userCategoryMapper = sqlSession.getMapper(UserCategoryMapper.class);
            cate = userCategoryMapper.getUserCate(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return cate;
    }

}
