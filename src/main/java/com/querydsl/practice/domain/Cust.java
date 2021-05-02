package com.querydsl.practice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Cust {
    @Id
    private String custnum;

    private String custnm;

    public Cust(String custnum, String custnm) {
        this.custnum = custnum;
        this.custnm = custnm;
    }

}
