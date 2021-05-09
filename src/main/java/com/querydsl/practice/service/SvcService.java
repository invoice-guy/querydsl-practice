package com.querydsl.practice.service;

import com.querydsl.practice.domain.SvcRepository;
import com.querydsl.practice.dto.SvcSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SvcService {
    private final SvcRepository svcRepository;

    @Transactional
    public void saveService(SvcSaveRequestDto requestDto) {
        svcRepository.save(requestDto.toEntity());
    }

}
