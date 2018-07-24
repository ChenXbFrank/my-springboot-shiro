package com.cxb.myspringbootshiro.controller;

import com.cxb.myspringbootshiro.domain.User;
import com.cxb.myspringbootshiro.result.Result;
import com.cxb.myspringbootshiro.result.ResultGenerator;
import com.cxb.myspringbootshiro.service.ShiroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;

/**
 * @author zhaodong zhaodongxx@outlook.com
 * @version v1.0
 * @since 2018/7/19 10:53
 */
@RestController
public class RegisterController {

    @Resource
    private ShiroService shiroService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        int code = (int)(Math.random() * (400000000 -100000000)) + 100000000; // 产生1000-9999之间的一个随机数
        String id = String.valueOf(code);
        String newpwd = shiroService.encodeByBCrypt(password);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("password", newpwd);
        shiroService.addUser(map);
        return ResultGenerator.genSuccessResult(map).setMessage("注册成功");
    }
}
