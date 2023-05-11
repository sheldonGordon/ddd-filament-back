package fr.chatelain.filament.printer.repository;

import fr.chatelain.filament.core.entity.printer.Printer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrinterRepositoryInterface extends CrudRepository<Printer, String> {

}
