package com.kshrd.registration.controller;

import com.kshrd.registration.model.Relative;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.repository.RelativeRepo;
import com.kshrd.registration.service.serviceimp.RelativeImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RelativeController {

    private final RelativeImp relativeImp;

    public RelativeController(RelativeImp relativeImp) {
        this.relativeImp = relativeImp;
    }

    @GetMapping("/relative")
    public ResponseEntity<Object> getAllRelative() throws Exception {
        List<Relative> relative = relativeImp.getAllRelative();

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Get all relative successfully",
                "/relative",true, relative,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());

    }
}
