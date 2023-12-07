package org.magalhaes.types;

public enum VehicleType {
    cars,
    trucks,
    motorcycles;

    public String getVehicleTypeInPT() {
        String translation = null;
        switch (this) {
            case cars -> translation = "carros";
            case trucks -> translation = "caminhoes";
            case motorcycles -> translation = "motos";
        }
        return translation;
    }
}
