package fr.chatelain.filament.core.entity.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.List;

@Data
public class DtoAccount {
    private String id;
    private String aliasName;
    private String firstName;
    private String lastName;
    private List<String> listIdPrinter;
}
