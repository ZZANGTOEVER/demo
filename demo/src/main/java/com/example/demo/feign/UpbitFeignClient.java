package com.example.demo.feign;

import com.example.demo.dto.CandleInfoDto;
import com.example.demo.dto.UpbitMarketDto;
import com.example.demo.dto.UpbitPriceInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "UpbitFeignClient", url = "https://api.upbit.com/v1")
public interface UpbitFeignClient {

    // 마켓 코드 조회
    @GetMapping(value = "/market/all")
    List<UpbitMarketDto> getMarketList();

    // 현재가 정보
    @GetMapping(value = "/ticker/")
    List<UpbitPriceInfoDto> getTicker(@RequestParam("markets") String coinStr);

    // 시세 캔들 조회
    @GetMapping(value = "/candles/{candleUrl}")
    List<CandleInfoDto.Response> getCandle(@PathVariable("candleUrl") String candleUrl,
                                           @RequestParam("market") String market,
                                           @RequestParam("to") String to,
                                           @RequestParam("count") Integer count);

}
