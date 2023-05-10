package fr.chatelain.filament.core.entity.dto;

import fr.chatelain.filament.core.entity.filament.Material;
import lombok.Data;


@Data
public class BrandFilament {
    private String id;
    private String name;
    private String color;
    private boolean silk;
    private boolean diamond;
    private Material material;
    private DtoPrinter picture;
}
