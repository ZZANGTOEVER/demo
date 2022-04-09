package com.example.demo.dao;


import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Repository
public class RedisDao {
    @Resource(name = "redisTemplate")
    ValueOperations valueOperations;

    @Resource(name = "redisTemplate")
    ListOperations listOperations;

    public void RedisSet(String key, String value){
        valueOperations.set(key, value);
    }

    public String RedisGet(String key){
        String value = (String) valueOperations.get(key);
        return value;
    }

    public void RedisaddList(String key, String value){
        listOperations.rightPush(key, value);
    }

    public ArrayList<String> RedisGetList(String key){
        ArrayList list = (ArrayList) listOperations.range(key, 0, -1);
        return list;
    }

}
