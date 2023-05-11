package fr.chatelain.filament.core.entity.account;

import fr.chatelain.filament.core.entity.AbstractEntities;
import fr.chatelain.filament.core.entity.printer.Printer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class Account extends AbstractEntities {
    @Column(unique = true, nullable = false, length = 20)
    private String aliasName;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;

    @Transient
    private List<Printer> listPrinter;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "list_printer", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "printer_id")
    private List<String> listIdPrinter;

    protected Account(String aliasName, String firstName, String lastName, List<Printer> listPrinter) {
        super();
        this.aliasName = aliasName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.listPrinter = listPrinter;
    }

}
