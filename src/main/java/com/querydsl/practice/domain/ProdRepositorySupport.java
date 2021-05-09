package com.querydsl.practice.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.practice.dto.ProdTermRequestDto;
import com.querydsl.practice.dto.SvcProdResponseDto;
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

    //Projections이 머지??
    public List<SvcProdResponseDto> findAllProdBySvcnum(String svcnum) {
        return queryFactory.select(Projections.fields(SvcProdResponseDto.class,svc.svcnum,prod.svcmgmtnum,prod.effenddtm,prod.effstadtm,prod.prodid,prod.scrbdt,prod.termdt))
                .from(prod)
                .join(svc).on(prod.svcmgmtnum.eq(svc.id))
                .where(svc.svcnum.eq(svcnum))
                .fetch();
    }

    public List<SvcProdResponseDto> findActiveProdBySvcmgmtnum(int svcmgmtnum) {
        return queryFactory.select(Projections.fields(SvcProdResponseDto.class,prod.svcmgmtnum,prod.effenddtm,prod.effstadtm,prod.prodid,prod.scrbdt,prod.termdt))
                .from(prod)
                .where(prod.svcmgmtnum.eq(svcmgmtnum),prod.effenddtm.eq("99991231235959"))
                .fetch();
    }

    public Prod findProdByPk(ProdTermRequestDto requestDto) {
        return queryFactory.selectFrom(prod)
                .where(prod.svcmgmtnum.eq(requestDto.getSvcmgmtnum()),
                        prod.effenddtm.eq(requestDto.getEffenddtm()),
                        prod.effstadtm.eq(requestDto.getEffstadtm()),
                        prod.prodid.eq(requestDto.getProdid()))
                .fetchOne();
    }

}