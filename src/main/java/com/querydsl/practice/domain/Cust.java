package com.querydsl.practice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cust {
    @Id
    @Column(name = "custnum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String custnm;

    @Builder
    public Cust(String custnm) {
        this.custnm = custnm;
    }


}
