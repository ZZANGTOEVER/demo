package com.example.demo.controller;

import com.example.demo.dto.BitthumbPriceInfoDTO;
import com.example.demo.dto.UpbitPriceInfoDto;
import com.example.demo.service.bitthumb.BitthumbService;
import com.example.demo.dto.PriceInfoDTO;
import com.example.demo.service.upbit.UpbitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@RestController
@Api(value = "가격정보 컨트롤러")
@RequiredArgsConstructor
@RequestMapping("/")
public class PriceInfoController {
    private final BitthumbService bitthumbService;
    private final UpbitService upbitService;
    private final String KRW_PREFIX = "KRW-";

    @ApiOperation(value = "CurrentPrice", tags = "ticker",
            httpMethod = "POST",
            response = PriceInfoDTO.class,
            notes = "빗썸 ticker"
    )
    @PostMapping(value = "main/CurrentPrice")
    public List<List<PriceInfoDTO>> getTicker(){
        List<List<PriceInfoDTO>> result = new ArrayList<>();
        BitthumbPriceInfoDTO bitthumbData = bitthumbService.getTicker();
        HashMap<String, UpbitPriceInfoDto> upbitData = upbitService.getALLTicker();
        String[] tmpMarket = {"BTC", "ETH", "XRP", "DOGE"};

        for(String marketNm : tmpMarket){
            List<PriceInfoDTO> tmpList = new ArrayList<>();
            PriceInfoDTO bitthumbTmp = new PriceInfoDTO();
            PriceInfoDTO upbitTmp = new PriceInfoDTO();
            bitthumbTmp.setCoinNm(marketNm+"-bitthumb");
            bitthumbTmp.setOpeningPrice(((LinkedHashMap)bitthumbData.getData().get(marketNm)).get("opening_price").toString());
            bitthumbTmp.setClosingPrice(((LinkedHashMap)bitthumbData.getData().get(marketNm)).get("closing_price").toString());
            bitthumbTmp.setMaxPrice(((LinkedHashMap)bitthumbData.getData().get(marketNm)).get("max_price").toString());
            bitthumbTmp.setMinPrice(((LinkedHashMap)bitthumbData.getData().get(marketNm)).get("min_price").toString());

            upbitTmp.setCoinNm(marketNm+"-upbit");
            upbitTmp.setOpeningPrice(Integer.toString(upbitData.get(KRW_PREFIX+marketNm).getOpening_price().intValue()));
            upbitTmp.setClosingPrice(Integer.toString(upbitData.get(KRW_PREFIX+marketNm).getTrade_price().intValue()));
            upbitTmp.setMaxPrice(Integer.toString(upbitData.get(KRW_PREFIX+marketNm).getHigh_price().intValue()));
            upbitTmp.setMinPrice(Integer.toString(upbitData.get(KRW_PREFIX+marketNm).getLow_price().intValue()));

            tmpList.add(bitthumbTmp);
            tmpList.add(upbitTmp);

            result.add(tmpList);
        }
        return result;
    }

}
