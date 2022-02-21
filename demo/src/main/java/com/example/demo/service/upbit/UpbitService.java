package com.example.demo.service.upbit;

import com.example.demo.dto.UpbitMarketDto;
import com.example.demo.dto.UpbitPriceInfoDto;
import com.example.demo.feign.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UpbitService {

    private final UpbitFeignClient upbitFeignClient;

    public List<UpbitMarketDto> getMarketList() {
        return upbitFeignClient.getMarketList();
    }

    public List<UpbitPriceInfoDto> getTicker(String markets) {
        return upbitFeignClient.getTicker(markets);
    }

    public HashMap<String, UpbitPriceInfoDto> getALLTicker() {
        HashMap<String, UpbitPriceInfoDto> result = new HashMap<>();
        List<UpbitPriceInfoDto> res = upbitFeignClient.getTicker("KRW-BTC, KRW-ETH, KRW-XRP, KRW-DOGE");
        for(UpbitPriceInfoDto tmp : res){
            result.put(tmp.getMarket(), tmp);
        }
        return result;
    }
}
