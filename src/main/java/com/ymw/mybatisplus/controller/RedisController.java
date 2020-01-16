package com.ymw.mybatisplus.controller;

import com.ymw.mybatisplus.bean.User;
import com.ymw.mybatisplus.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;

/**
 *  使用redis之前记得开启 相关服务 与配置信息
 *
 * @author: ymingwang
 * @create: 2019-10-31 17:41
 **/
@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/user/save")
    public void saveUser() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("18");
        user.setGmtModified(new Date());
        user.setUsername((String) redisUtil.get("mykey"));
        redisUtil.set("userZhang", user);
    }
    @RequestMapping("/user/get")
    public User getUser() {
        return (User) redisUtil.get("userZhang");
    }
    @RequestMapping("/user/getStr")
    public Json getStr() {
        return (Json) redisUtil.get("mykey");
    }
}
