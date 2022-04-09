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
    private final String BTC_PREFIX = "BTC-";

    @ApiOperation(value = "CurrentPrice", tags = "ticker",
            httpMethod = "POST",
            response = PriceInfoDTO.class,
            notes = "빗썸 ticker"
    )
    @PostMapping(value = "main/CurrentPrice")
    public List<List<PriceInfoDTO>> getTicker(){
        String[] tmpMarket = {"BTC", "ETH", "XRP", "DOGE"};
        List<List<PriceInfoDTO>> result = new ArrayList<>();
        BitthumbPriceInfoDTO bitthumbDataKrw = bitthumbService.getTickerKrw();
        BitthumbPriceInfoDTO bitthumbDataBtc = bitthumbService.getTickerBtc();
        HashMap<String, UpbitPriceInfoDto> upbitDataKrw = upbitService.getKrwTicker(tmpMarket);
        HashMap<String, UpbitPriceInfoDto> upbitDataBtc = upbitService.getBtcTicker(tmpMarket);

        for(String marketNm : tmpMarket){
            List<PriceInfoDTO> tmpList = new ArrayList<>();
            PriceInfoDTO bitthumbTmp = new PriceInfoDTO();
            PriceInfoDTO upbitTmp = new PriceInfoDTO();
            bitthumbTmp.setCoinNm(marketNm+"-bitthumb");
            bitthumbTmp.setOpeningPriceKrw(((LinkedHashMap)bitthumbDataKrw.getData().get(marketNm)).get("opening_price").toString());
            bitthumbTmp.setClosingPriceKrw(((LinkedHashMap)bitthumbDataKrw.getData().get(marketNm)).get("closing_price").toString());
            bitthumbTmp.setMaxPriceKrw(((LinkedHashMap)bitthumbDataKrw.getData().get(marketNm)).get("max_price").toString());
            bitthumbTmp.setMinPriceKrw(((LinkedHashMap)bitthumbDataKrw.getData().get(marketNm)).get("min_price").toString());
            bitthumbTmp.setTradeVolKrw(((LinkedHashMap)bitthumbDataKrw.getData().get(marketNm)).get("acc_trade_value").toString());
            if(bitthumbDataBtc.getData().get(marketNm)!=null){
                bitthumbTmp.setOpeningPriceBtc(((LinkedHashMap)bitthumbDataBtc.getData().get(marketNm)).get("opening_price").toString());
                bitthumbTmp.setClosingPriceBtc(((LinkedHashMap)bitthumbDataBtc.getData().get(marketNm)).get("closing_price").toString());
                bitthumbTmp.setMaxPriceBtc(((LinkedHashMap)bitthumbDataBtc.getData().get(marketNm)).get("max_price").toString());
                bitthumbTmp.setMinPriceBtc(((LinkedHashMap)bitthumbDataBtc.getData().get(marketNm)).get("min_price").toString());
                bitthumbTmp.setTradeVolBtc(((LinkedHashMap)bitthumbDataBtc.getData().get(marketNm)).get("acc_trade_value").toString());
            }


            upbitTmp.setCoinNm(marketNm+"-upbit");
            UpbitPriceInfoDto upbitkKrw = upbitDataKrw.get(KRW_PREFIX+marketNm);
            upbitTmp.setOpeningPriceKrw(Integer.toString(upbitkKrw.getOpening_price().intValue()));
            upbitTmp.setClosingPriceKrw(Integer.toString(upbitkKrw.getTrade_price().intValue()));
            upbitTmp.setMaxPriceKrw(Integer.toString(upbitkKrw.getHigh_price().intValue()));
            upbitTmp.setMinPriceKrw(Integer.toString(upbitkKrw.getLow_price().intValue()));
            upbitTmp.setTradeVolKrw(Integer.toString(upbitkKrw.getAcc_trade_price().intValue()));
            if(upbitDataBtc.get(BTC_PREFIX+marketNm) != null){
                UpbitPriceInfoDto upbitkBtc = upbitDataBtc.get(BTC_PREFIX+marketNm);
                upbitTmp.setOpeningPriceBtc(Integer.toString(upbitkBtc.getOpening_price().intValue()));
                upbitTmp.setClosingPriceBtc(Integer.toString(upbitkBtc.getTrade_price().intValue()));
                upbitTmp.setMaxPriceBtc(Integer.toString(upbitkBtc.getHigh_price().intValue()));
                upbitTmp.setMinPriceBtc(Integer.toString(upbitkBtc.getLow_price().intValue()));
                upbitTmp.setTradeVolBtc(Integer.toString(upbitkBtc.getAcc_trade_price().intValue()));
            }
            tmpList.add(bitthumbTmp);
            tmpList.add(upbitTmp);

            result.add(tmpList);
        }
        return result;
    }

}
