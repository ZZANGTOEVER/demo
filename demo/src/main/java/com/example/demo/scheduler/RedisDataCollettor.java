package com.example.demo.scheduler;

import com.example.demo.dao.RedisDao;
import com.example.demo.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
@EnableAsync
public class RedisDataCollettor {
    @Autowired
    RedisService redisService = new RedisService();

//    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(cron = "0 1 * * *")
    public void scheduleTaskUsingCronExpression(){
        try{
            String[] tmpMarket = {"KRW-BTC", "KRW-ETH", "KRW-XRP", "KRW-DOGE"};
            for(String coinNm : tmpMarket){
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet("https://api.upbit.com/v1/candles/days?market="+coinNm+"&count=1");
                request.setHeader("Content-Type", "application/json");
                HttpResponse response = client.execute(request);
                HttpEntity entity = response.getEntity();
                String res = EntityUtils.toString(entity, "UTF-8");
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(res);
                redisService.addList(coinNm,res);
                log.info(obj.toString());
            }
        }
        catch (IOException e){
            log.error(e.toString());
        }
        catch (ParseException e){
            log.error(e.toString());
        }
    }
}
