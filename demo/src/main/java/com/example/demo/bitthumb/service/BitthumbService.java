package com.example.demo.bitthumb.service;

import com.example.demo.feign.BitthumbFeignClient;
import com.example.demo.bitthumb.dto.TickerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BitthumbService {

    private final BitthumbFeignClient bitthumbFeignClient;

    public TickerDTO getTicker() {
        return bitthumbFeignClient.getTicker();
    }
}
