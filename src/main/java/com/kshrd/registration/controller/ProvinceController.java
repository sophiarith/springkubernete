package com.kshrd.registration.controller;


import com.kshrd.registration.model.Province;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.serviceimp.ProvinceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ProvinceController {

    private final ProvinceImp provinceImp;

    public ProvinceController(ProvinceImp provinceImp) {
        this.provinceImp = provinceImp;
    }

    @GetMapping("/province")
    public ResponseEntity<Object> getAllProvince() throws Exception {
        List<Province> province = provinceImp.getAllProvince();
        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Get all provinces successfully",
                "/province",true, province,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }
}
