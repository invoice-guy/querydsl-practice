package com.querydsl.practice.dto;

import com.querydsl.practice.domain.Cust;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustSaveRequestDto {
    private int id;

    private String custnm;

    @Builder
    public CustSaveRequestDto(String custnm) {
        this.custnm=custnm;
    }

    public Cust toEntity() {
        return Cust.builder()
                .custnm(custnm)
                .build();
    }
}
