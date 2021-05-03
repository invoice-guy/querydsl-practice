package com.querydsl.practice.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.practice.dto.SvcProd;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.practice.domain.QProd.prod;
import static com.querydsl.practice.domain.QSvc.svc;


@Repository
public class ProdRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public ProdRepositorySupport(JPAQueryFactory queryFactory) {
        super(Prod.class);
        this.queryFactory = queryFactory;
    }

    public List<Prod> findProdBySvcmgmtnum(String svcmgmtnum) {
        return queryFactory.selectFrom(prod)
                .where(prod.svcmgmtnum.eq(svcmgmtnum))
                .fetch();
    }

    //Projections이 머지??
    public List<SvcProd> findProdBySvcnum(String svcnum) {
        return queryFactory.select(Projections.fields(SvcProd.class,svc.svcnum,prod.svcmgmtnum,prod.effenddtm,prod.effstadtm,prod.prodid,prod.scrbdt,prod.termdt))
                .from(prod)
                .join(svc).on(prod.svcmgmtnum.eq(svc.svcmgmtnum))
                .where(svc.svcnum.eq(svcnum))
                .fetch();
    }

    public List<Prod> findBySvcmgmtnumProdid(String svcmgmtnum, String effenddtm, String effstadtm, String prodid)  {
        return queryFactory.selectFrom(prod)
                .where(prod.svcmgmtnum.eq(svcmgmtnum),
                        prod.effenddtm.eq(effenddtm),
                        prod.effstadtm.eq(effstadtm),
                        prod.prodid.eq(prodid))
                .fetch();
    }
}