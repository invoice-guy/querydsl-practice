package com.querydsl.practice;

import com.querydsl.practice.domain.*;

import com.querydsl.practice.dto.SvcCust;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuerydslTest {
    @Autowired
    private SvcRepository svcRepository;

    @Autowired
    private SvcRepositorySupport svcRepositorySupport;

    @Autowired
    private CustRepository custRepository;

    @Autowired
    private CustRepositorySupport custRepositorySupport;

    @Test
    public void select_svcmgmtnum_by_svcnum() {
        //String svcmgmtnum = "701243";
        //String svcnum = "01028268646";
        //String custnum = "7000000000";

        //svcRepository.save(new Svc(svcmgmtnum, svcnum, custnum));

        svcRepository.saveAll(Arrays.asList(
                new Svc("70000","01028268646","80000"),
                new Svc("70001","01010005134","80001"),
                new Svc("70002","01091245875","80002")
                ));

        List<Svc> result = svcRepositorySupport.findBySvcnum("01010005134");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getSvcmgmtnum(), is("70001"));
    }

    @Test
    public void select_custnm_by_custnum() {
        //String custnum = "7000000000";
        //String custnm = "chihoon";

        custRepository.saveAll(Arrays.asList(
                new Cust("80000","chihoon"),
                new Cust("80001","insoo"),
                new Cust("80002","sookyung")
                ));

        List<Cust> result = custRepositorySupport.findByCustnm("80001");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getCustnm(), is("insoo"));
    }

    @Test
    public void select_custnm_by_svcnum() {
        svcRepository.saveAll(Arrays.asList(
                new Svc("70000","01028268646","80000"),
                new Svc("70001","01010005134","80001"),
                new Svc("70002","01091245875","80002")
        ));

        custRepository.saveAll(Arrays.asList(
                new Cust("80000","chihoon"),
                new Cust("80001","insoo"),
                new Cust("80002","sookyung")
        ));

        List<SvcCust> result = svcRepositorySupport.findCustnmBySvcnum("01028268646");

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getCustnm(), is("sookyung"));
    }

}
