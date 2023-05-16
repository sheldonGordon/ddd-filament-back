package fr.chatelain.filament.filament.controller;

import fr.chatelain.filament.core.entity.dto.DtoFilament;
import fr.chatelain.filament.core.entity.dto.DtoPrinter;
import fr.chatelain.filament.core.entity.filament.Filament;
import fr.chatelain.filament.filament.service.BrandService;
import fr.chatelain.filament.filament.service.FilamentService;
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
@RequestMapping("/filament")
public class FilamentController {
    @Autowired
    private FilamentService filamentService;

    @Autowired
    private BrandService brandService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private HttpHeaders headers;

    public FilamentController() {
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoFilament> findById(@PathVariable("id") String id){
        try{
            Filament filament = filamentService.findById(id).orElseThrow();
            return new ResponseEntity<>(convertToDto(filament), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/printer/{printer_id}")
    public ResponseEntity<DtoFilament> save(@RequestBody DtoFilament dtoFilament, @PathVariable("printer_id") String printerId){
        Filament filament = convertToEntity(dtoFilament);
        filament.setId(UUID.randomUUID().toString());
        if(filament.getBrand() != null){
            filament.getBrand().setId(UUID.randomUUID().toString());
            brandService.save(filament.getBrand());
        }
        DtoFilament filamentCreated = convertToDto(filamentService.save(filament));

        final WebClient webClient=webClientBuilder.baseUrl("http://localhost:8083").build();
        StringBuilder uri = new StringBuilder();
        uri.append("/printer/");
        uri.append(printerId);
        uri.append("/filament/");
        uri.append(filamentCreated.getId());
        webClient.patch().uri(uri.toString()).retrieve().bodyToMono(DtoPrinter.class).block();
        return new ResponseEntity<>(filamentCreated, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DtoFilament> update(@RequestBody DtoFilament dtoFilament){
        Filament filament = convertToEntity(dtoFilament);
        DtoFilament filamentCreated = convertToDto(filamentService.save(filament));
        return new ResponseEntity<>(filamentCreated, headers, HttpStatus.CREATED);
    }

    private DtoFilament convertToDto(Filament filament) {
        return modelMapper.map(filament, DtoFilament.class);
    }

    private Filament convertToEntity(DtoFilament dtoFilament) {
        return modelMapper.map(dtoFilament, Filament.class);
    }

    public FilamentService getFilamentService() {
        return filamentService;
    }

    public void setFilamentService(FilamentService filamentService) {
        this.filamentService = filamentService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
