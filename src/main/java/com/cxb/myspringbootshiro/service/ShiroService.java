package com.cxb.myspringbootshiro.service;

import com.cxb.myspringbootshiro.dao.UserDao;
import com.cxb.myspringbootshiro.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <P></P>
 *
 * @author zhaodong zhaodongxx@outlook.com
 * @version v1.0
 * @since 2018/3/30 22:59
 */
@Service
public class ShiroService {

    @Autowired
    private UserDao userDao;

    @Deprecated
    public String getPasswordByUsername(String username) {
        User userByUserName = userDao.getUserByUserName(username);
        return userByUserName.getUsername();
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        return userDao.getUserByUserName(username);
    }

    /**
     * 添加用户
     * @return
     */
    public void addUser( HashMap<String, Object> map) {
        userDao.saveUser(map);
    }

    public String encodeByMD5(String password) {
        return new SimpleHash("MD5", password).toHex();
    }

    public String encodeByMD5AndSalt(String password, String salt) {
        return new SimpleHash("MD5", password, ByteSource.Util.bytes(salt)).toHex();
    }

    public String encodeByBCrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
