package com.example.demo.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class PriceInfoDTO {
    private String coinNm;
    private String openingPriceKrw	    ; // 시가 00시 기준	Number (String)
    private String closingPriceKrw	    ; // 종가 00시 기준	Number (String)
    private String minPriceKrw	        ; // 저가 00시 기준	Number (String)
    private String maxPriceKrw	        ; // 고가 00시 기준	Number (String)
    private String tradeVolKrw;
    private String openingPriceBtc	    ; // 시가 00시 기준	Number (String)
    private String closingPriceBtc	    ; // 종가 00시 기준	Number (String)
    private String minPriceBtc	        ; // 저가 00시 기준	Number (String)
    private String maxPriceBtc	        ; // 고가 00시 기준	Number (String)
    private String tradeVolBtc;
}
