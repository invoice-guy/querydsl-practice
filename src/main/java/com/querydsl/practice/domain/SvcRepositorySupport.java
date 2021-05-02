package com.querydsl.practice.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.practice.dto.SvcCust;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.practice.domain.QSvc.svc;
import static com.querydsl.practice.domain.QCust.cust;


@Repository
public class SvcRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public SvcRepositorySupport(JPAQueryFactory queryFactory) {
        super(Svc.class);
        this.queryFactory = queryFactory;
    }

    public List<Svc> findBySvcnum(String svcnum) {
        return queryFactory.selectFrom(svc)
                .where(svc.svcnum.eq(svcnum))
                .fetch();
    }

    public List<SvcCust> findCustnmBySvcnum(String svcnum) {
        return queryFactory.select(Projections.fields(SvcCust.class,cust.custnm))
                .from(cust)
                .join(svc).on(cust.custnum.eq(svc.custnum))
                .where(svc.svcnum.eq(svcnum))
                .fetch();
    }
}