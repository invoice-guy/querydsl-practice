package com.querydsl.practice.domain;

import com.querydsl.practice.dto.CustSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustRepositoryTest {
    @Autowired
    private CustRepository custRepository;

    @Autowired
    private CustRepositorySupport custRepositorySupport;

    @Test
    public void 고객_생성_테스트() {
        CustSaveRequestDto requestDto = CustSaveRequestDto.builder()
                .custnm("황치훈")
                .build();

        custRepository.save(requestDto.toEntity());

        List<Cust> result = custRepository.findAll();

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getCustnm(), is("황치훈"));
    }

}
