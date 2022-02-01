package com.example.demo.bitthumb;

import com.example.demo.bitthumb.dto.TickerDTO;
import com.example.demo.bitthumb.service.BitthumbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(value = "테스트 컨트롤러")
@RequiredArgsConstructor
public class BitthumbController {
    private final BitthumbService bitthumbService;
    @ApiOperation(value = "빗썸 ticker", tags = "ticker",
            httpMethod = "GET",
            response = TickerDTO.class,
            notes = "빗썸 ticker"
    )
    @GetMapping(value = "/v1.0/bitthumb/ticker")
    public TickerDTO getTicker() {
        return bitthumbService.getTicker();
    }

}
