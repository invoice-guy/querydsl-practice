package com.querydsl.practice.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//@IdClass(Prod.ProdKey.class)
@Getter
@NoArgsConstructor
@Entity
@Table(
        /*
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"svc_mgmt_num", "prod_id", "eff_sta_dtm", "eff_end_dtm"})
        },*/
        name = "prod",
        indexes = {
                @Index(name = "prod_n1",
                        columnList = "svcmgmtnum, prodid, effenddtm desc, effstadtm desc",
                        unique = true)
        }
)
public class Prod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int svcmgmtnum;

//    @Id
    private String effenddtm;

//    @Id
    private String effstadtm;

//    @Id
    private String prodid;

    private String scrbdt;
    private String termdt;

/* PK를 여러개 지정하기 위한 기법 */
/*    @EqualsAndHashCode
    @Embeddable
    static class ProdKey implements Serializable {
        private int svcmgmtnum;
        private String effenddtm;
        private String effstadtm;
        private String prodid;
    }
*/


    @Builder
    public Prod(int svcmgmtnum, String effenddtm, String effstadtm, String prodid, String scrbdt, String termdt) {
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
