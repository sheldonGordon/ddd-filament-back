package fr.chatelain.filament.printer.controller;

import fr.chatelain.filament.core.entity.dto.DtoAccount;
import fr.chatelain.filament.core.entity.dto.DtoPrinter;
import fr.chatelain.filament.core.entity.printer.Printer;
import fr.chatelain.filament.printer.service.PictureService;
import fr.chatelain.filament.printer.service.PrinterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@RestController
@RequestMapping("/printer")
public class PrinterController {
    @Autowired
    private PrinterService printerService;

    @Autowired
    private PictureService pictureService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private HttpHeaders headers;

    public PrinterController() {
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoPrinter> findById(@PathVariable("id") String id){
        try{
            Printer printer = printerService.findById(id).orElseThrow();
            return new ResponseEntity<>(convertToDto(printer), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/account/{account_id}")
    public ResponseEntity<DtoPrinter> save(@RequestBody DtoPrinter dtoPrinter, @PathVariable("account_id") String accountId){
        Printer printer = convertToEntity(dtoPrinter);
        printer.setId(UUID.randomUUID().toString());
        if(printer.getPicture() != null){
            printer.getPicture().setId(UUID.randomUUID().toString());
            pictureService.save(printer.getPicture());
        }
        DtoPrinter printerCreated = convertToDto(printerService.save(printer));

        final WebClient webClient=webClientBuilder.baseUrl("http://localhost:8081").build();
        StringBuilder uri = new StringBuilder();
        uri.append("/account/");
        uri.append(accountId);
        uri.append("/printer/");
        uri.append(printerCreated.getId());
        webClient.patch().uri(uri.toString()).retrieve().bodyToMono(DtoAccount.class).block();
        return new ResponseEntity<>(printerCreated, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DtoPrinter> update(@RequestBody DtoPrinter dtoPrinter){
        Printer printer = convertToEntity(dtoPrinter);
        if(printer.getPicture() != null){
            if(printer.getPicture().getId() == null){
                printer.getPicture().setId(UUID.randomUUID().toString());
            }
            pictureService.save(printer.getPicture());
        }
        DtoPrinter printerCreated = convertToDto(printerService.save(printer));
        return new ResponseEntity<>(printerCreated, headers, HttpStatus.CREATED);
    }

    private DtoPrinter convertToDto(Printer printer) {
        return modelMapper.map(printer, DtoPrinter.class);
    }

    private Printer convertToEntity(DtoPrinter dtoPrinter) {
        return modelMapper.map(dtoPrinter, Printer.class);
    }

    public PrinterService getPrinterService() {
        return printerService;
    }

    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PictureService getPictureService() {
        return pictureService;
    }

    public void setPictureService(PictureService pictureService) {
        this.pictureService = pictureService;
    }
}
