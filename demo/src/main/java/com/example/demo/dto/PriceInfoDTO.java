package com.example.demo.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class PriceInfoDTO {
    private String coinNm;
    private String openingPrice	    ; // 시가 00시 기준	Number (String)
    private String closingPrice	    ; // 종가 00시 기준	Number (String)
    private String minPrice	        ; // 저가 00시 기준	Number (String)
    private String maxPrice	        ; // 고가 00시 기준	Number (String)

}
