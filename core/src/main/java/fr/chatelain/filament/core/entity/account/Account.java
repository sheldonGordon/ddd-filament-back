package fr.chatelain.filament.core.entity.account;

import fr.chatelain.filament.core.entity.AbstractEntities;
import fr.chatelain.filament.core.entity.printer.Printer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
public class Account extends AbstractEntities {
    @Column(unique = true, nullable = false, length = 20)
    String aliasName;
    @Column(nullable = false, length = 50)
    String firstName;
    @Column(nullable = false, length = 50)
    String lastName;
    @Transient
    List<Printer> listPrinter;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "list_printer", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "printer_id")
    List<String> listIdPrinter;

    public Account(String aliasName, String firstName, String lastName, List<Printer> listPrinter) {
        this.aliasName = aliasName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.listPrinter = listPrinter;
    }
}
