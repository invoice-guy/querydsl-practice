package com.querydsl.practice.web;

import com.querydsl.practice.domain.ProdRepositorySupport;
import com.querydsl.practice.dto.SvcProd;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SvcApiController {

    //Autowired 는 머지??
    @Autowired
    private ProdRepositorySupport prodRepositorySupport;

    @GetMapping("/api/v1/svc/{svcnum}")
    public List<SvcProd> hello(@PathVariable String svcnum) {
        List<SvcProd> result = prodRepositorySupport.findProdBySvcnum(svcnum);

        return result;
    }
//    public String hello(@PathVariable String svcnum) {
//        return "hello hwang = " + svcnum;
//    }


}
