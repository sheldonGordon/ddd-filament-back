package fr.chatelain.filament.printer.service;

import fr.chatelain.filament.core.entity.printer.Picture;
import fr.chatelain.filament.printer.repository.PictureRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    private PictureRepositoryInterface pictureRepository;

    public Picture save(Picture picture){
        return pictureRepository.save(picture);
    }
    public PictureRepositoryInterface getPictureRepository() {
        return pictureRepository;
    }

    public void setPictureRepository(PictureRepositoryInterface pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
}
