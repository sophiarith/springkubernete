package com.kshrd.registration.service.serviceimp;

import com.kshrd.registration.model.Education;
import com.kshrd.registration.repository.EducationRepo;
import com.kshrd.registration.service.EducationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationImp implements EducationService {

    private final EducationRepo educationRepo;

    public EducationImp(EducationRepo educationRepo) {
        this.educationRepo = educationRepo;
    }

    @Override
    public List<Education> getAllEducation() throws Exception {
        try{
            List<Education> educations = educationRepo.getAllEducation();
            return  educations;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
