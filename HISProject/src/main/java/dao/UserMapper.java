package dao;

import entity.User;

public interface UserMapper {
    User getUserByUserName(String userName);
}
