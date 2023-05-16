package fr.chatelain.filament.filament.service;

import fr.chatelain.filament.core.entity.filament.Filament;
import fr.chatelain.filament.filament.repository.FilamentRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilamentService {
    @Autowired
    private FilamentRepositoryInterface filamentRepository;

    public Filament save(Filament filament){
        return filamentRepository.save(filament);
    }

    public Optional<Filament> findById(String id){
        return filamentRepository.findById(id);
    }
    public FilamentRepositoryInterface getFilamentRepository() {
        return filamentRepository;
    }

    public void setFilamentRepository(FilamentRepositoryInterface filamentRepository) {
        this.filamentRepository = filamentRepository;
    }
}
