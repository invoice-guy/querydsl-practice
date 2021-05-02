package com.querydsl.practice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Svc {
    @Id
    private String svcmgmtnum;

    private String svcnum;
    private String svcstcd;
    private String svcscrbdt;
    private String svctermdt;

    private String custnum;

    public Svc(String svcmgmtnum, String svcnum, String custnum) {
        this.svcmgmtnum = svcmgmtnum;
        this.svcnum = svcnum;
        this.custnum = custnum;
    }

    @Builder
    public Svc(String svcmgmtnum, String svcnum, String svcstcd, String svcscrbdt, String svctermdt, String custnum) {
        this.svcmgmtnum = svcmgmtnum;
        this.svcnum = svcnum;
        this.svcstcd = svcstcd;
        this.svcscrbdt = svcscrbdt;
        this.svctermdt = svctermdt;
        this.custnum = custnum;
    }
}
