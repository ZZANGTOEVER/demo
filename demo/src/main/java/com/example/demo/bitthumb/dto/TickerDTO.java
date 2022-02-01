package com.example.demo.bitthumb.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class TickerDTO {
    private String status;
    private HashMap data;
//    private String opening_price	    ; // 시가 00시 기준	Number (String)
//    private String closing_price	    ; // 종가 00시 기준	Number (String)
//    private String min_price	        ; // 저가 00시 기준	Number (String)
//    private String max_price	        ; // 고가 00시 기준	Number (String)
//    private String units_traded 	    ; // 거래량 00시 기준	Number (String)
//    private String acc_trade_value	    ; // 거래금액 00시 기준	Number (String)
//    private String prev_closing_price	; // 전일종가	Number (String)
//    private String units_traded_24H	    ; // 최근 24시간 거래량	Number (String)
//    private String acc_trade_value_24H	; // 최근 24시간 거래금액	Number (String)
//    private String fluctate_24H	        ; // 최근 24시간 변동가	Number (String)
//    private String fluctate_rate_24H	; // 최근 24시간 변동률	Number (String)
//    private String date	                ; // 타임 스탬프	Integer(String)
}
