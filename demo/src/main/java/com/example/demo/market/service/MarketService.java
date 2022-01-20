package com.example.demo.market.service;

import com.example.demo.feign.UpbitFeignClient;
import com.example.demo.market.dto.MarketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarketService {

    private final UpbitFeignClient upbitFeignClient;

    public List<MarketDto> getMarketList() {
        return upbitFeignClient.getMarketList();
    }
}
