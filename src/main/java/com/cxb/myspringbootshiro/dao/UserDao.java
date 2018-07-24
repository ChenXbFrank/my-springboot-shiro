package com.cxb.myspringbootshiro.dao;

import com.cxb.myspringbootshiro.domain.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 81046 on 2018-07-24
 */
public interface UserDao {

    User getUserByUserName(String username);

    List<User> getUserListByUsername(String username);

    void saveUser(HashMap<String, Object> map);

}
