package com.amano.springbootredis.controller;

import com.amano.springbootredis.pojo.User;
import com.amano.springbootredis.service.inter.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @ClassName RedisController
 * @Author User
 * @date 2020.03.25 15:50
 */
@RestController
public class RedisController {
    @Autowired
    RedisService redisService;

    @GetMapping("cache")
    public User testCache(String key) {
        return redisService.getCache(key);
    }

    @PostMapping("cache")
    public User testCache(User user) {
        return redisService.setCache(String.valueOf(user.getUserid()), user);
    }
}
