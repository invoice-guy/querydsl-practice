package com.querydsl.practice;

import com.querydsl.practice.domain.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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

    @Autowired
    private ProdRepository prodRepository;

    @Autowired
    private ProdRepositorySupport prodRepositorySupport;

/*
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

    @Test
    public void select_prod_by_svcnum() {
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

        List<Svc> result = svcRepositorySupport.findBySvcnum("01028268646");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getSvcmgmtnum(), is("70000"));

        String svcmgmtnum=result.get(0).getSvcmgmtnum();

        System.out.println("get svcmgmt_num = " + svcmgmtnum);

        prodRepository.save(new Prod(svcmgmtnum, "99991231235959", "20210503090000", "NA00001600" , "20210503", "99991231"));
        prodRepository.save(new Prod(svcmgmtnum, "99991231235959", "20210503090000", "NA00002500" , "20210503", "99991231"));

        List<Prod> result2 = prodRepositorySupport.findProdBySvcmgmtnum("70000");

        assertThat(result2.size(), is(2));
        assertThat(result2.get(0).getProdid(), is("NA00001600"));
        assertThat(result2.get(1).getProdid(), is("NA00002500"));

        List<SvcProd> result3 = prodRepositorySupport.findProdBySvcnum("01028268646");

        assertThat(result3.size(), is(2));
        assertThat(result3.get(0).getProdid(), is("NA00001600"));
        assertThat(result3.get(1).getProdid(), is("NA00002500"));

        assertThat(result3.get(0).getEffenddtm(), is("99991231235959"));
    }

    @Test
    public void term_prod() {
        prodRepository.save(new Prod("70000", "99991231235959", "20210503090000", "NA00001600", "20210503", "99991231"));
        prodRepository.save(new Prod("70000", "99991231235959", "20210503090000", "NA00002500", "20210503", "99991231"));

        List<Prod> result = prodRepositorySupport.findBySvcmgmtnumProdid("70000","99991231235959","20210503090000","NA00001600");

        assertThat(result.size(), is(1));

        Prod prod = result.get(0);

        prod.TermProd("20210503220000","20210503");

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getEffenddtm(), is("20210503220000"));
    }

 */

}

