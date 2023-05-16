package fr.chatelain.filament.printer.controller;

import fr.chatelain.filament.core.entity.dto.DtoPicture;
import fr.chatelain.filament.core.entity.printer.Picture;
import fr.chatelain.filament.printer.service.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    private HttpHeaders headers;

    @PutMapping
    public ResponseEntity<DtoPicture> update(@RequestBody DtoPicture dtoPicture){
        Picture picture = convertToEntity(dtoPicture);
        DtoPicture pictureCreated = convertToDto(pictureService.save(picture));
        return new ResponseEntity<>(pictureCreated, headers, HttpStatus.CREATED);
    }

    private DtoPicture convertToDto(Picture picture) {
        return modelMapper.map(picture, DtoPicture.class);
    }

    private Picture convertToEntity(DtoPicture dtoPicture) {
        return modelMapper.map(dtoPicture, Picture.class);
    }
    public PictureService getPictureService() {
        return pictureService;
    }

    public void setPictureService(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
