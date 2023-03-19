package com.kshrd.registration.controller;

import com.kshrd.registration.model.Generation;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.serviceimp.GenerationImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GenerationController {

    private final GenerationImp generationImp;

    public GenerationController(GenerationImp generationImp) {
        this.generationImp = generationImp;
    }

    @GetMapping("/generation")
    public ResponseEntity<Object> getOpenGeneration() throws Exception {
        Generation generation = generationImp.getOpenGeneration();
        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Get a open generation successfully",
                "/generation",true, generation,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }
}
