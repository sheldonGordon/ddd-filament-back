package fr.chatelain.filament.filament.repository;

import fr.chatelain.filament.core.entity.filament.BrandFilament;
import fr.chatelain.filament.core.entity.filament.Filament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepositoryInterface extends CrudRepository<BrandFilament, String> {

}
