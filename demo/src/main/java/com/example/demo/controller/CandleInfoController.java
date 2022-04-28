package com.example.demo.controller;

import com.example.demo.dto.CandleInfoDto;
import com.example.demo.enums.CandleType;
import com.example.demo.service.upbit.UpbitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "시세 캔들 정보 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CandleInfoController {

    private final UpbitService upbitService;

    @ApiOperation(
            value = "CandleInfo",
            tags = "candle",
            notes = "시세 캔들 조회 - 분(Minute), 일(Day), 주(Week), 월(Month)"
    )
    @GetMapping(value = "main/Candle")
    public List<CandleInfoDto.Response> getCandle(
            @ApiParam(value = "캔들 타입", name = "candleType", required = true)
            @RequestParam(value = "candleType") CandleType candleType,
            @ApiParam(value = "마켓 코드 (KRW-BTC)", name = "market", example = "KRW-BTC", required = true)
            @RequestParam(value = "market") String market,
            @ApiParam(value = "마지막 캔들 시각 (yyyy-MM-dd HH:mm:SS)", name = "to", example = "2022-04-28 13:14:15")
            @RequestParam(value = "to", required = false) String to,
            @ApiParam(value = "캔들 개수 (최대 200개)", name = "count", example = "30")
            @RequestParam(value = "count", required = false) Integer count) {
        return upbitService.getCandle(CandleInfoDto.Request.builder()
                .candleType(candleType)
                .market(market)
                .to(to)
                .count(count)
                .build());
    }
}