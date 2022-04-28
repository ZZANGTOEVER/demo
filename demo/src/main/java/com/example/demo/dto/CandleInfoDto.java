package com.example.demo.dto;

import com.example.demo.enums.CandleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class CandleInfoDto {

    @Getter
    @Setter
    @Builder
    @ApiModel(value = "캔들 요청 모델")
    public static class Request {

        @NotNull
        @ApiModelProperty(value = "시간 타입", example = "ONE_MINUTE", required = true)
        private CandleType candleType;

        @NotNull
        @ApiModelProperty(value = "마켓 코드", example = "KRW-BTC", required = true)
        private String market;

        @ApiModelProperty(value = "마지막 캔들 시각", example = "2022-04-28 13:14:15")
        private String to;

        @Max(value = 200)
        @ApiModelProperty(value = "캔들 개수 (최대 200개)", example = "30")
        private Integer count;
    }

    @Getter
    @Setter
    @Builder
    @ApiModel(value = "캔들 응답 모델")
    public static class Response {

        @ApiModelProperty(value = "마켓명", example = "KRW-BTC")
        private String market;

        @ApiModelProperty(value = "캔들 기준 시각(UTC 기준)", example = "2018-04-18T10:15:00")
        private String candle_date_time_utc;

        @ApiModelProperty(value = "캔들 기준 시각(KST 기준)", example = "2018-04-18T19:16:00")
        private String candle_date_time_kst;

        @ApiModelProperty(value = "시가", example = "8615000")
        private Double opening_price;

        @ApiModelProperty(value = "고가", example = "8618000")
        private Double high_price;

        @ApiModelProperty(value = "저가", example = "8611000")
        private Double low_price;

        @ApiModelProperty(value = "종가", example = "8616000")
        private Double trade_price;

        @ApiModelProperty(value = "해당 캔들에서 마지막 틱이 저장된 시각", example = "1524046594584")
        private Long timestamp;

        @ApiModelProperty(value = "누적 거래 금액", example = "60018891.90054")
        private Double candle_acc_trade_price;

        @ApiModelProperty(value = "누적 거래량", example = "6.96780929")
        private Double candle_acc_trade_volume;

        @ApiModelProperty(value = "분 단위(유닛)",example = "1")
        private Integer unit;
    }
}
