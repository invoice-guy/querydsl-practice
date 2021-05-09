package com.querydsl.practice.service;

import com.querydsl.practice.domain.Prod;
import com.querydsl.practice.domain.ProdRepository;
import com.querydsl.practice.domain.ProdRepositorySupport;
import com.querydsl.practice.dto.ProdSaveRequestDto;
import com.querydsl.practice.dto.ProdTermRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ProdService {
    private final ProdRepository prodRepository;
    private final ProdRepositorySupport prodRepositorySupport;

    @Transactional
    public void subscribeProd(ProdSaveRequestDto requestDto) {
        prodRepository.save(requestDto.toEntity());
    }

    @Transactional
    public void termProd(ProdTermRequestDto requestDto) {
        Prod prod = prodRepositorySupport.findProdByPk(requestDto);

        prod.TermProd("20210509200000","20210509");
    }
}
