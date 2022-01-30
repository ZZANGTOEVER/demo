package com.example.demo.feign;

import com.example.demo.upbit.dto.MarketDto;
import com.example.demo.upbit.dto.TickerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "UpbitFeignClient", url = "https://api.upbit.com/v1")
public interface UpbitFeignClient {

    // 마켓 코드 조회
    @GetMapping(value = "/market/all")
    List<MarketDto> getMarketList();

    // 현재가 정보
    @GetMapping(value = "/ticker/")
    List<TickerDto> getTicker(@RequestParam("markets") String markets);
}
