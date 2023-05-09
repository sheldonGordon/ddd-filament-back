package fr.chatelain.filament.core.entity.filament;

import fr.chatelain.filament.core.entity.printer.Picture;

public class FactoryFilament {

    public FactoryFilament() {
    }

    public static BrandFilament getInstanceBrandFilament(){
        return new BrandFilament();
    }

    public static BrandFilament getInstanceBrandFilament(String name, String color, boolean silk, boolean diamond, Material material, Picture picture){
        return new BrandFilament(name, color, silk, diamond, material, picture);
    }

    public static Filament getInstanceFilament(){
        return new Filament();
    }

    public static Filament getInstanceFilament(BrandFilament brand, double extrusionMultiplier, int bedTemperatureFirstLayer, int bedTemperatureOtherLayer, int extruderTemperatureFirstLayer, int extruderTemperatureOtherLayer, int lengthRetraction){
        return new Filament(brand, extrusionMultiplier, bedTemperatureFirstLayer, bedTemperatureOtherLayer, extruderTemperatureFirstLayer, extruderTemperatureOtherLayer, lengthRetraction);
    }
}
