package com.example.demo.feign;

import com.example.demo.dto.BitthumbPriceInfoDTO;
import com.example.demo.dto.UpbitPriceInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ObjectInputFilter;
import java.util.List;

@FeignClient(name = "BitthumbFeignClient", url = "https://api.bithumb.com/public/ticker/", configuration = ObjectInputFilter.Config.class)
public interface BitthumbFeignClient {

    @GetMapping(value = "/ALL_KRW")
    BitthumbPriceInfoDTO getTickerKrw();

    @GetMapping(value = "/ALL_BTC")
    BitthumbPriceInfoDTO getTickerBtc();
}
