package com.example.demo.upbit;

import com.example.demo.upbit.dto.MarketDto;
import com.example.demo.upbit.dto.TickerDto;
import com.example.demo.upbit.service.UpbitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UpbitController {

    private final UpbitService upbitService;

    @GetMapping(value = "/v1.0/upbit/market")
    public List<MarketDto> getMarket() {
        return upbitService.getMarketList();
    }

    @GetMapping(value = "/v1.0/upbit/ticker")
    public List<TickerDto> getTicker(@RequestParam String markets) {
        return upbitService.getTicker(markets);
    }
}
