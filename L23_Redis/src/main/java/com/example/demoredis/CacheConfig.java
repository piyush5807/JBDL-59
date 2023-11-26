package com.example.demoredis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {


    @Bean
    public LettuceConnectionFactory getConnectionFactory(){

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("redis-10738.c89.us-east-1-3.ec2.cloud.redislabs.com", 10738);
        configuration.setPassword("9IRBTCY7VUsFVOACtvgPlH2nZ066gMEP");
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);
        return lettuceConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> getTemplate(){
//
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(
//                new RedisStandaloneConfiguration()
//        );

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getConnectionFactory());

//        redisTemplate.afterPropertiesSet();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer()); // ~field
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer()); // value for a field

        return redisTemplate;

    }

    private ObjectMapper getMapper(){
        return new ObjectMapper();
    }

}
