package com.example.demo.service.upbit;

import com.example.demo.dto.CandleInfoDto;
import com.example.demo.dto.UpbitMarketDto;
import com.example.demo.dto.UpbitPriceInfoDto;
import com.example.demo.feign.UpbitFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
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

    public List<CandleInfoDto.Response> getCandle(CandleInfoDto.Request request) {
        List<CandleInfoDto.Response> responseList;

        responseList = upbitFeignClient.getCandle(request.getCandleType().getUrl(),
                    request.getMarket(),
                    request.getTo(),
                    request.getCount());

        responseList.forEach(response -> log.info("result: {}", response));

        return responseList;
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
