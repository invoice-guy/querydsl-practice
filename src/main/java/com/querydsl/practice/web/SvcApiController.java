package com.querydsl.practice.web;

import com.querydsl.practice.domain.Svc;
import com.querydsl.practice.domain.SvcRepositorySupport;
import com.querydsl.practice.dto.SvcCustResponseDto;
import com.querydsl.practice.dto.SvcSaveRequestDto;
import com.querydsl.practice.service.SvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SvcApiController {

    //Autowired 는 머지??
//    @Autowired
//    private ProdRepositorySupport prodRepositorySupport;

    private final SvcService svcService;
    private final SvcRepositorySupport svcRepositorySupport;

    @PostMapping("/api/v1/svc")
    public void save(@RequestBody SvcSaveRequestDto requestDto){
        svcService.saveService(requestDto);
    }

    @GetMapping("/api/v1/svc/{svcnum}")
    public List<Svc> find(@PathVariable String svcnum) {
        return svcRepositorySupport.findBySvcnum(svcnum);
    }

    @GetMapping("/api/v1/svc/findcustinfo/{svcnum}")
    public List<SvcCustResponseDto> findcustinfo(@PathVariable String svcnum) {
        return svcRepositorySupport.findCustnmBySvcnum(svcnum);
    }

/*
    @GetMapping("/api/v1/svc/hwang/{svcnum}")
    public String hello(@PathVariable String svcnum) {
        return "hello hwang = " + svcnum;
    }
*/

}
