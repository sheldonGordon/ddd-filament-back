package fr.chatelain.filament.core.entity;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntities implements Serializable {
    protected AbstractEntities() {
        this.id = UUID.randomUUID().toString();
    }
    @Id
    @Getter
    @Setter
    private String id;
}
