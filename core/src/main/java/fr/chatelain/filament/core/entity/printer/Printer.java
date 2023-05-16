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
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "list_filament", joinColumns = @JoinColumn(name = "printer_id"))
    @Column(name = "filament_id")
    private List<String> listIdFilament;

    public Printer(String name, String model, Picture picture, List<Filament> listFilament) {
        super();
        this.name = name;
        this.model = model;
        this.picture = picture;
        this.listFilament = listFilament;
    }
}
