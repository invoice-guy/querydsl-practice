package com.querydsl.practice.domain;

import com.querydsl.practice.dto.*;
import com.querydsl.practice.service.ProdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdRepositoryTest {
    @Autowired
    private ProdRepository prodRepository;

    @Autowired
    private ProdRepositorySupport prodRepositorySupport;

    @Autowired
    private SvcRepository svcRepository;

    @Autowired
    private SvcRepositorySupport svcRepositorySupport;

    @Test
    public void 상품_가입_테스트() {
        ProdSaveRequestDto requestDto = ProdSaveRequestDto.builder()
                .svcmgmtnum(1)
                .effenddtm("99991231235959")
                .effstadtm("20210508090000")
                .prodid("NA00002500")
                .scrbdt("20210508")
                .termdt("")
                .build();

        prodRepository.save(requestDto.toEntity());

        List<Prod> result = prodRepository.findAll();

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getProdid(), is("NA00002500"));
    }

    @Test
    public void 서비스번호로_모든상품조회_테스트() {
        ProdSaveRequestDto requestDto1 = ProdSaveRequestDto.builder()
                .svcmgmtnum(1)
                .effenddtm("99991231235959")
                .effstadtm("20210508090000")
                .prodid("NA00002500")
                .scrbdt("20210508")
                .termdt("")
                .build();

        prodRepository.save(requestDto1.toEntity());

        SvcSaveRequestDto requestDto2 = SvcSaveRequestDto.builder()
                .svcnum("01028268646")
                .svcstcd("AC")
                .svcscrbdt("20210507")
                .svctermdt("")
                .custnum(1)
                .build();

        svcRepository.save(requestDto2.toEntity());

        List<SvcProdResponseDto> result = prodRepositorySupport.findAllProdBySvcnum("01028268646");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getProdid(), is("NA00002500"));
    }

    @Test
    public void 서비스관리번호로_살아있는_상품조회_테스트() {
        List<Prod> prod = Arrays.asList(
                Prod.builder()
                        .svcmgmtnum(1)
                        .effenddtm("20210509230000")
                        .effstadtm("20210508090000")
                        .prodid("NA00002500")
                        .scrbdt("20210508")
                        .termdt("")
                        .build(),
                Prod.builder()
                        .svcmgmtnum(1)
                        .effenddtm("99991231235959")
                        .effstadtm("20210508090000")
                        .prodid("NA00002000")
                        .scrbdt("20210508")
                        .termdt("")
                        .build()
        );

        prodRepository.saveAll(prod);


        List<SvcProdResponseDto> result = prodRepositorySupport.findActiveProdBySvcmgmtnum(1);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getProdid(), is("NA00002000"));
    }

    @Test
    public void PK로_상품조회_및_해지_테스트() {
        List<Prod> prod = Arrays.asList(
                Prod.builder()
                        .svcmgmtnum(1)
                        .effenddtm("20210509230000")
                        .effstadtm("20210508090000")
                        .prodid("NA00002500")
                        .scrbdt("20210508")
                        .termdt("")
                        .build(),
                Prod.builder()
                        .svcmgmtnum(1)
                        .effenddtm("99991231235959")
                        .effstadtm("20210508090000")
                        .prodid("NA00002000")
                        .scrbdt("20210508")
                        .termdt("")
                        .build()
        );

        prodRepository.saveAll(prod);

        ProdTermRequestDto requestDto = ProdTermRequestDto.builder()
                .svcmgmtnum(1)
                .effenddtm("99991231235959")
                .effstadtm("20210508090000")
                .prodid("NA00002000")
                .build();

        Prod result = prodRepositorySupport.findProdByPk(requestDto);

        //then
        assertThat(result.getProdid(), is("NA00002000"));

        result.TermProd("20210508230000","20210508");

        assertThat(result.getEffenddtm(), is("20210508230000"));
    }


}
