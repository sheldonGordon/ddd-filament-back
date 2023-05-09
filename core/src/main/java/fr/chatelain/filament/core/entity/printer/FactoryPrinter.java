package fr.chatelain.filament.core.entity.printer;

import fr.chatelain.filament.core.entity.filament.Filament;

import java.util.List;

public class FactoryPrinter {

    public FactoryPrinter() {
    }
    public static Picture getInstancePicture(){
        return new Picture();
    }

    public static Picture getInstancePicture(String data, String name, String typeMime){
        return new Picture(data, name, typeMime);
    }

    public static Printer getInstancePrinter(){
        return new Printer();
    }

    public static Printer getInstancePrinter(String name, String model, Picture picture, List<Filament> listFilament){
        return new Printer(name, model, picture, listFilament);
    }
}
