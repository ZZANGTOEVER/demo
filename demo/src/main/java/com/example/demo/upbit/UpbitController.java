package com.example.demo.upbit;

import com.example.demo.bitthumb.dto.TickerDTO;
import com.example.demo.upbit.dto.MarketDto;
import com.example.demo.upbit.dto.TickerDto;
import com.example.demo.upbit.service.UpbitService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "업비트 getMarketList", tags = "getMarketList",
            httpMethod = "GET",
            response = TickerDTO.class,
            notes = "업비트 getMarketList"
    )
    @GetMapping(value = "/v1.0/upbit/market")
    public List<MarketDto> getMarket() {
        return upbitService.getMarketList();
    }

    @ApiOperation(value = "업비트 ticker", tags = "ticker",
            httpMethod = "GET",
            response = TickerDTO.class,
            notes = "업비트 ticker"
    )
    @GetMapping(value = "/v1.0/upbit/ticker")
    public List<TickerDto> getTicker(@RequestParam String markets) {
        return upbitService.getTicker(markets);
    }
}
