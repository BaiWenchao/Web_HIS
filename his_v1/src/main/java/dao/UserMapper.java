package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getUserByUserName(String userName);

    List<String> getUserName(@Param("dept") int dept, @Param("regLevel") int regLevel);

    User getUserByRealName(String realName);

    int getUserId(String realName);
}
