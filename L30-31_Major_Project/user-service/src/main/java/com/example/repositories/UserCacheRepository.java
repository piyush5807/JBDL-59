package com.example.repositories;

import com.example.models.User;
import com.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserCacheRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void save(User user){
        this.redisTemplate.opsForValue().set(getKey(user.getUserId()), user, Constants.USER_REDIS_KEY_EXPIRY, TimeUnit.SECONDS);
    }

    public User get(int userId){
        return (User) this.redisTemplate.opsForValue().get(getKey(userId));
    }

    private String getKey(int userId){
        return Constants.USER_REDIS_KEY_PREFIX + userId;
    }
}
