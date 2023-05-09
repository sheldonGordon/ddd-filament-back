package fr.chatelain.filament.core.entity.printer;

import fr.chatelain.filament.core.entity.AbstractEntities;
import fr.chatelain.filament.core.entity.filament.Filament;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class Printer extends AbstractEntities {
    @Column
    private String name;
    @Column
    private String model;
    @OneToOne
    private Picture picture;
    @Transient
    private List<Filament> listFilament;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ID_PRINTER", nullable = false)
    private List<String> listIdFilament;

    public Printer(String name, String model, Picture picture, List<Filament> listFilament) {
        this.name = name;
        this.model = model;
        this.picture = picture;
        this.listFilament = listFilament;
    }
}
