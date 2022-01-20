package com.example.demo.market;

import com.example.demo.market.dto.MarketDto;
import com.example.demo.market.service.MarketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @GetMapping(value = "/v1.0/upbit/market")
    public List<MarketDto> getMarket() {
        return marketService.getMarketList();
    }
}
