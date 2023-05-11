package fr.chatelain.filament.printer.repository;

import fr.chatelain.filament.core.entity.printer.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepositoryInterface extends CrudRepository<Picture, String> {

}
