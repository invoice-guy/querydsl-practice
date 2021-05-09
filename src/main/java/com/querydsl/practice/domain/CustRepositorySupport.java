package com.querydsl.practice.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.practice.domain.QCust.cust;

@Repository
public class CustRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public CustRepositorySupport(JPAQueryFactory queryFactory) {
        super(Cust.class);
        this.queryFactory = queryFactory;
    }

/*
    public List<Cust> findByCustnm(String custnum) {
        return queryFactory.selectFrom(cust)
                .where(cust.custnum.eq(custnum))
                .fetch();
    }
*/
}

