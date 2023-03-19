package com.kshrd.registration.service.serviceimp;

import com.kshrd.registration.controller.RelativeController;
import com.kshrd.registration.model.Relative;
import com.kshrd.registration.repository.RelativeRepo;
import com.kshrd.registration.service.RelativeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelativeImp implements RelativeService {

    private final RelativeRepo relativeRepo;

    public RelativeImp(RelativeRepo relativeRepo) {
        this.relativeRepo = relativeRepo;
    }

    @Override
    public List<Relative> getAllRelative() throws Exception {
        try{
            List<Relative> relatives = relativeRepo.getAllRelative();
            return relatives;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
