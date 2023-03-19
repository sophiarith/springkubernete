package com.kshrd.registration.controller;

import com.kshrd.registration.model.Education;
import com.kshrd.registration.payload.response.ResponseRes;
import com.kshrd.registration.service.serviceimp.EducationImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EducationController {

    private final EducationImp educationImp;

    public EducationController(EducationImp educationImp) {
        this.educationImp = educationImp;
    }

    @GetMapping("/education")
    public ResponseEntity<Object> getAllEducation() throws Exception {
        List<Education> educations = educationImp.getAllEducation();
        ResponseRes responseRes = new ResponseRes(
                HttpStatus.OK.value(), LocalDateTime.now(),HttpStatus.OK,"Get all educations successfully",
                "/education",true, educations,null
        );
        return new ResponseEntity<>(responseRes, responseRes.getHttpMessage());
    }

}
