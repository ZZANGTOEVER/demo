package com.example.demo.enums;

public enum CandleType {
    ONE_MINUTE("minutes/1"),
    THREE_MINUTE("minutes/3"),
    FIVE_MINUTE( "minutes/5"),
    TEN_MINUTE("minutes/10"),
    FIFTEEN_MINUTE("minutes/15"),
    THIRTY_MINUTE("minutes/30"),
    ONE_HOUR("minutes/60"),
    FOUR_HOUR("minutes/240"),
    ONE_DAY("/days"),
    ONE_WEEK("/weeks"),
    ONE_MONTH("/months");

    private String url;

    CandleType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
