package com.kshrd.registration.service.serviceimp;

import com.kshrd.registration.model.Province;
import com.kshrd.registration.repository.ProvinceRepo;
import com.kshrd.registration.service.ProvinceService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceImp implements ProvinceService {

    private final ProvinceRepo provinceRepo;

    public ProvinceImp(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    @Override
    public List<Province> getAllProvince() throws Exception {
        try {
            List<Province> province = provinceRepo.getAllProvince();
            return province;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
