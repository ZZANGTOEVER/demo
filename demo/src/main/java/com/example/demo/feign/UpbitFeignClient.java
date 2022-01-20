package com.example.demo.feign;

import com.example.demo.market.dto.MarketDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ObjectInputFilter;
import java.util.List;

@FeignClient(name = "UpbitFeignClient", url = "https://api.upbit.com/v1/market/all", configuration = ObjectInputFilter.Config.class)
public interface UpbitFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    List<MarketDto> getMarketList();
}
