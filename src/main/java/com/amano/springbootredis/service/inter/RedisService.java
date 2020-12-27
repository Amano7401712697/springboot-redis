package com.amano.springbootredis.service.inter;

import com.amano.springbootredis.pojo.User;

public interface RedisService {
    public User getCache(String key);

    public User setCache(String key, User user);
}
