package fr.chatelain.filament.core.entity.printer;

import fr.chatelain.filament.core.entity.AbstractEntities;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class Picture extends AbstractEntities {
    @Column(columnDefinition = "text")
    private String data;

    @Column
    private String name;

    @Column
    private String typeMime;
}
