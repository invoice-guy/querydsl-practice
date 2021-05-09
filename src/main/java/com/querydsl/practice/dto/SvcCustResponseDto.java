package com.querydsl.practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcCustResponseDto {
    private int svcmgmtnum;
    private String svcnum;
    private String custnm;
    private String svcstcd;
    private String svcscrbdt;
    private String svctermdt;
    private int custnum;
}
