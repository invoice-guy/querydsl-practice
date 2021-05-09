package com.querydsl.practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcProdResponseDto {
    private String svcnum;
    private int svcmgmtnum;
    private String effenddtm;
    private String effstadtm;
    private String prodid;
    private String scrbdt;
    private String termdt;
}
