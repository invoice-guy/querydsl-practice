package com.querydsl.practice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Svc {
    @Id
    @Column(name = "svcmgmtnum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String svcnum;
    private String svcstcd;
    private String svcscrbdt;
    private String svctermdt;
    private int custnum;

    /*
    public Svc(String svcmgmtnum, String svcnum, String custnum) {
        this.svcmgmtnum = svcmgmtnum;
        this.svcnum = svcnum;
        this.custnum = custnum;
    }
*/
    @Builder
    public Svc(String svcnum, String svcstcd, String svcscrbdt, String svctermdt, int custnum) {
        this.svcnum = svcnum;
        this.svcstcd = svcstcd;
        this.svcscrbdt = svcscrbdt;
        this.svctermdt = svctermdt;
        this.custnum = custnum;
    }

}

