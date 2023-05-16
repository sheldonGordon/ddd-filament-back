package fr.chatelain.filament.filament.service;

import fr.chatelain.filament.core.entity.filament.BrandFilament;
import fr.chatelain.filament.filament.repository.BrandRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepositoryInterface brandRepositoryInterface;

    public BrandFilament save(BrandFilament brand){
        return brandRepositoryInterface.save(brand);
    }

    public Optional<BrandFilament> findById(String id){
        return brandRepositoryInterface.findById(id);
    }

    public BrandRepositoryInterface getBrandRepositoryInterface() {
        return brandRepositoryInterface;
    }

    public void setBrandRepositoryInterface(BrandRepositoryInterface brandRepositoryInterface) {
        this.brandRepositoryInterface = brandRepositoryInterface;
    }
}
