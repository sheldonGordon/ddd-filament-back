package fr.chatelain.filament.core.entity.dto;

import lombok.Data;

import java.util.HashSet;

@Data
public class DtoAccount {
    private String id;
    private String aliasName;
    private String firstName;
    private String lastName;
    private HashSet<DtoPrinter> listPrinter;
}
