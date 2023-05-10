package fr.chatelain.filament.core.entity.dto;

import fr.chatelain.filament.core.entity.filament.Filament;
import lombok.Data;

import java.util.List;

@Data
public class DtoPrinter {
    private String id;
    private String name;
    private String model;
    private DtoPicture picture;
    private List<Filament> listFilament;
}
