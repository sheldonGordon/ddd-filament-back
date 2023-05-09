package fr.chatelain.filament.core.entity.account;

import fr.chatelain.filament.core.entity.printer.Printer;

import java.util.List;

public class FactoryAccount {

    public FactoryAccount() {
    }

    public static Account getInstanceAccount(){
        return new Account();
    }

    public static Account getInstanceAccount(String aliasName, String firstName, String lastName, List<Printer> listPrinter){
        return new Account(aliasName, firstName, lastName, listPrinter);
    }

}
