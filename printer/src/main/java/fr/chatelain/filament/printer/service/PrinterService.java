package fr.chatelain.filament.printer.service;

import fr.chatelain.filament.core.entity.printer.Printer;
import fr.chatelain.filament.printer.repository.PictureRepositoryInterface;
import fr.chatelain.filament.printer.repository.PrinterRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrinterService {
    @Autowired
    private PrinterRepositoryInterface printerRepository;

    @Autowired
    private PictureRepositoryInterface pictureRepository;

    public Optional<Printer> findById(String id){
        return printerRepository.findById(id);
    }

    public Printer save(Printer printer){
        return printerRepository.save(printer);
    }

    public PrinterRepositoryInterface getPrinterRepository() {
        return printerRepository;
    }

    public void setPrinterRepository(PrinterRepositoryInterface printerRepository) {
        this.printerRepository = printerRepository;
    }

    public PictureRepositoryInterface getPictureRepository() {
        return pictureRepository;
    }

    public void setPictureRepository(PictureRepositoryInterface pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
}
