package com.example.demo.service.redis;


import com.example.demo.dao.RedisDao;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RedisService {
    @Autowired
    RedisDao redisDao;

    public void set(String key, String value){
        redisDao.RedisSet(key, value);
    }

    public String get(String key){
        return redisDao.RedisGet(key);
    }

    public void addList(String key, String value){
        redisDao.RedisaddList(key, value);
    }

    public ArrayList<Object> getList(String key) throws ParseException {
        ArrayList<String> resultStrList = redisDao.RedisGetList(key);
        ArrayList<Object> result = new ArrayList<Object>();
        JSONParser jsonParser = new JSONParser();
        for(String res : resultStrList){
            Object obj = jsonParser.parse(res);
            result.add(obj);
        }
        return result;
    }
}