package com.amano.springbootredis.service.impl;

import com.amano.springbootredis.pojo.User;
import com.amano.springbootredis.service.inter.RedisService;
import com.amano.springbootredis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @ClassName RedisServiceImpl
 * @Author User
 * @date 2020.03.25 15:51
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisUtil redisUtil;


    @Override
    public User getCache(String key) {
        return redisUtil.get(key, User.class);
    }

    @Override
    public User setCache(String key, User user) {
        boolean result = redisUtil.set(String.valueOf(user.getUserid()), user);
        if (result) {
            return redisUtil.get(String.valueOf(user.getUserid()), User.class);
        }
        return null;
    }
}
