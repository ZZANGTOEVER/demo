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

    public HashMap<String, UpbitPriceInfoDto> getKrwTicker(String[] coinList) {
        HashMap<String, UpbitPriceInfoDto> result = new HashMap<>();
        String reqStr = "";
        for(String coinNm : coinList){
            reqStr += "KRW-"+ coinNm + ", ";
        }
        reqStr = reqStr.substring(0, reqStr.length()-2);
        List<UpbitPriceInfoDto> res = upbitFeignClient.getTicker(reqStr);
        for(UpbitPriceInfoDto tmp : res){
            result.put(tmp.getMarket(), tmp);
        }
        return result;
    }

    public HashMap<String, UpbitPriceInfoDto> getBtcTicker(String[] coinList) {
        HashMap<String, UpbitPriceInfoDto> result = new HashMap<>();
        String reqStr = "";
        for(String coinNm : coinList){
            if(coinNm.equals("BTC"))
                    continue;
            reqStr += "BTC-"+ coinNm + ", ";
        }
        reqStr = reqStr.substring(0, reqStr.length()-2);
        List<UpbitPriceInfoDto> res = upbitFeignClient.getTicker(reqStr);
        for(UpbitPriceInfoDto tmp : res){
            result.put(tmp.getMarket(), tmp);
        }
        return result;
    }
}
