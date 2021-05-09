package com.querydsl.practice.service;


import com.querydsl.practice.domain.CustRepository;
import com.querydsl.practice.dto.CustSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CustService {
    private final CustRepository custRepository;

    @Transactional
    public void saveCust(CustSaveRequestDto requestDto) {
        custRepository.save(requestDto.toEntity());
    }

}
