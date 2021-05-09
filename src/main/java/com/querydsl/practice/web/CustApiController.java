package com.querydsl.practice.web;


import com.querydsl.practice.domain.CustRepositorySupport;
import com.querydsl.practice.dto.CustSaveRequestDto;
import com.querydsl.practice.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustApiController {
    private final CustService custService;
    private final CustRepositorySupport custRepositorySupport;

    @PostMapping("/api/v1/cust")
    public void save(@RequestBody CustSaveRequestDto requestDto){
        custService.saveCust(requestDto);
    }
}
