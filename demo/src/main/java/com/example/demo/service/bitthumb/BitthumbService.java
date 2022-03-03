package com.example.demo.service.bitthumb;

import com.example.demo.dto.BitthumbPriceInfoDTO;
import com.example.demo.feign.BitthumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BitthumbService {

    private final BitthumbFeignClient bitthumbFeignClient;

    public BitthumbPriceInfoDTO getTickerKrw() {
        return bitthumbFeignClient.getTickerKrw();
    }
    public BitthumbPriceInfoDTO getTickerBtc() {
        return bitthumbFeignClient.getTickerBtc();
    }
}
