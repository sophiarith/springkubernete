package com.kshrd.registration.service.serviceimp;

import com.kshrd.registration.model.Generation;
import com.kshrd.registration.repository.GenerationRepo;
import com.kshrd.registration.service.GenerationService;
import org.springframework.stereotype.Service;

@Service
public class GenerationImp implements GenerationService {

    private final GenerationRepo generationRepo;

    public GenerationImp(GenerationRepo generationRepo) {
        this.generationRepo = generationRepo;
    }

    @Override
    public Generation getOpenGeneration() throws Exception {
        try{
            Generation generation = generationRepo.getOpenGeneration();
            return  generation;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
