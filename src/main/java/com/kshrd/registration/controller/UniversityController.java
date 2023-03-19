package com.kshrd.registration.controller;

import com.kshrd.registration.model.University;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.serviceimp.UniversityImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UniversityController {

    private final UniversityImp universityImp;

    public UniversityController(UniversityImp universityImp) {
        this.universityImp = universityImp;
    }

    @GetMapping("/university")
    public ResponseEntity<Object> getAllUniversity() throws Exception {
        List<University> universities = universityImp.getAllUniversity();

        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Get all university successfully",
                "/university",true, universities,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }
}
