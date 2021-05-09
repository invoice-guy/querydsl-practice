package com.querydsl.practice.dto;


import com.querydsl.practice.domain.Prod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdSaveRequestDto {
    private int svcmgmtnum;
    private String effenddtm;
    private String effstadtm;
    private String prodid;
    private String scrbdt;
    private String termdt;

    @Builder
    public ProdSaveRequestDto(int svcmgmtnum, String effenddtm, String effstadtm, String prodid, String scrbdt, String termdt) {
        this.svcmgmtnum=svcmgmtnum;
        this.effenddtm=effenddtm;
        this.effstadtm=effstadtm;
        this.prodid=prodid;
        this.scrbdt=scrbdt;
        this.termdt=termdt;
    }

    public Prod toEntity() {
        return Prod.builder()
                .svcmgmtnum(svcmgmtnum)
                .effenddtm(effenddtm)
                .effstadtm(effstadtm)
                .prodid(prodid)
                .scrbdt(scrbdt)
                .termdt(termdt)
                .build();
    }
}
