package com.querydsl.practice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdTermRequestDto {
    private int svcmgmtnum;
    private String effenddtm;
    private String effstadtm;
    private String prodid;

    @Builder
    public ProdTermRequestDto(int svcmgmtnum, String effenddtm, String effstadtm, String prodid) {
        this.svcmgmtnum=svcmgmtnum;
        this.effenddtm=effenddtm;
        this.effstadtm=effstadtm;
        this.prodid=prodid;
    }
}
