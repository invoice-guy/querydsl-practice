package com.querydsl.practice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@IdClass(Prod.ProdKey.class)
public class Prod {
    @Id
    private String svcmgmtnum;

    @Id
    private String effenddtm;

    @Id
    private String effstadtm;

    @Id
    private String prodid;

    private String scrbdt;
    private String termdt;

/* PK를 여러개 지정하기 위한 기법 */
    @EqualsAndHashCode
    @Embeddable
    static class ProdKey implements Serializable {
        private String svcmgmtnum;
        private String effenddtm;
        private String effstadtm;
        private String prodid;
    }

    public Prod(String svcmgmtnum, String effenddtm, String effstadtm, String prodid, String scrbdt, String termdt) {
        this.svcmgmtnum = svcmgmtnum;
        this.effenddtm = effenddtm;
        this.effstadtm = effstadtm;
        this.prodid = prodid;
        this.scrbdt = scrbdt;
        this.termdt = termdt;
    }

    public void TermProd(String effenddtm, String termdt) {
        this.effenddtm = effenddtm;
        this.termdt = termdt;
    }
}
