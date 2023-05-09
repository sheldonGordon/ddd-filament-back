package fr.chatelain.filament.core.entity.filament;

import fr.chatelain.filament.core.entity.AbstractEntities;
import fr.chatelain.filament.core.entity.printer.Picture;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class BrandFilament extends AbstractEntities {
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 20)
    private String color;
    @Column
    private boolean silk;
    @Column
    private boolean diamond;
    @Enumerated(EnumType.STRING)
    private Material material;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="ID_PICTURE")
    private Picture picture;
}
