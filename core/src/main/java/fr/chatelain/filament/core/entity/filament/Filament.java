package fr.chatelain.filament.core.entity.filament;

import fr.chatelain.filament.core.entity.AbstractEntities;
import jakarta.persistence.*;

import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class Filament extends AbstractEntities {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true, optional = false)
    @JoinColumn(name="ID_BRAND")
    private BrandFilament brand;
    @Column
    private double extrusionMultiplier;
    @Column
    private int bedTemperatureFirstLayer;
    @Column
    private int bedTemperatureOtherLayer;
    @Column
    private int extruderTemperatureFirstLayer;
    @Column
    private int extruderTemperatureOtherLayer;
    @Column
    private int lengthRetraction;
}
