package com.querydsl.practice.web;

import com.querydsl.practice.domain.Svc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SvcApiController {
//    private final Svc svc;

    @GetMapping("/api/v1/svc/{id}")
    public String hello() {
        return "hello hwang";
    }
//    public PostsResponseDto findById(@PathVariable Long id) {
//        return postsService.findById(id);
//    }
}
