package fr.chatelain.filament.core.entity.dto;

import lombok.Data;


@Data
public class DtoFilament {
    private String id;
    private BrandFilament brand;
    private double extrusionMultiplier;
    private int bedTemperatureFirstLayer;
    private int bedTemperatureOtherLayer;
    private int extruderTemperatureFirstLayer;
    private int extruderTemperatureOtherLayer;
    private int lengthRetraction;
}
