package com.example.demo.feign;

import com.example.demo.dto.BitthumbPriceInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ObjectInputFilter;

@FeignClient(name = "BitthumbFeignClient", url = "https://api.bithumb.com/public/ticker/ALL_KRW", configuration = ObjectInputFilter.Config.class)
public interface BitthumbFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    BitthumbPriceInfoDTO getTicker();
}
