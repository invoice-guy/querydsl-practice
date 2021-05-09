package com.querydsl.practice.web;

import com.querydsl.practice.domain.ProdRepositorySupport;
import com.querydsl.practice.dto.ProdSaveRequestDto;
import com.querydsl.practice.dto.ProdTermRequestDto;
import com.querydsl.practice.dto.SvcProdResponseDto;
import com.querydsl.practice.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProdApiController {
    private final ProdService prodService;
    private final ProdRepositorySupport prodRepositorySupport;

    @PostMapping("/api/v1/prod")
    public void save(@RequestBody ProdSaveRequestDto requestDto){
        prodService.subscribeProd(requestDto);
    }

    @GetMapping("/api/v1/prod/findallprod/{svcnum}")
    public List<SvcProdResponseDto> findallprod(@PathVariable String svcnum){
        return prodRepositorySupport.findAllProdBySvcnum(svcnum);
    }

    @GetMapping("/api/v1/prod/findactiveprod/{svcmgmtnum}")
    public List<SvcProdResponseDto> findactiveprod(@PathVariable int svcmgmtnum){
        return prodRepositorySupport.findActiveProdBySvcmgmtnum(svcmgmtnum);
    }

    @PostMapping("/api/v1/termprod")
    public void termprod(@RequestBody ProdTermRequestDto requestDto){
        prodService.termProd(requestDto);
    }

}
