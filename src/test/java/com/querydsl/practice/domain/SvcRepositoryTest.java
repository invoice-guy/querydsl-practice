package com.querydsl.practice.domain;

import com.querydsl.practice.dto.CustSaveRequestDto;
import com.querydsl.practice.dto.SvcCustResponseDto;
import com.querydsl.practice.dto.SvcSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SvcRepositoryTest {
    @Autowired
    private SvcRepository svcRepository;

    @Autowired
    private SvcRepositorySupport svcRepositorySupport;

    @Autowired
    private CustRepository custRepository;

    @Autowired
    private CustRepositorySupport custRepositorySupport;

    @Test
    public void 서비스_생성_테스트() {
        SvcSaveRequestDto requestDto = SvcSaveRequestDto.builder()
                .svcnum("01028268646")
                .svcstcd("AC")
                .svcscrbdt("20210507")
                .svctermdt("")
                .build();

        svcRepository.save(requestDto.toEntity());

        List<Svc> result = svcRepository.findAll();

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getSvcnum(), is("01028268646"));
    }

    @Test
    public void 서비스번호로_조회_테스트() {
        SvcSaveRequestDto requestDto = SvcSaveRequestDto.builder()
                .svcnum("01028268646")
                .svcstcd("AC")
                .svcscrbdt("20210507")
                .svctermdt("")
                .build();

        svcRepository.save(requestDto.toEntity());

        List<Svc> result = svcRepositorySupport.findBySvcnum("01028268646");

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void 서비스번호로_고객명_조회_테스트() {
        SvcSaveRequestDto requestDto1 = SvcSaveRequestDto.builder()
                .svcnum("01028268646")
                .svcstcd("AC")
                .svcscrbdt("20210507")
                .svctermdt("")
                .custnum(1)
                .build();

        svcRepository.save(requestDto1.toEntity());

        CustSaveRequestDto requestDto2 = CustSaveRequestDto.builder()
                .custnm("황치훈")
                .build();

        custRepository.save(requestDto2.toEntity());

        List<SvcCustResponseDto> result = svcRepositorySupport.findCustnmBySvcnum("01028268646");

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getCustnm(), is("황치훈"));
    }

}
