package com.example.demo.upbit.service;

import com.example.demo.feign.UpbitFeignClient;
import com.example.demo.upbit.dto.MarketDto;
import com.example.demo.upbit.dto.TickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UpbitService {

    private final UpbitFeignClient upbitFeignClient;

    public List<MarketDto> getMarketList() {
        return upbitFeignClient.getMarketList();
    }

    public List<TickerDto> getTicker(String markets) {
        return upbitFeignClient.getTicker(markets);
    }
}
