package com.all4pets.Final.enumeraciones;

public enum Estado {

    PERDIDO("PERDIDO"),
    ADOPCION("ADOPCION");

//    private final String displayValue;
//
//    private Estado(String displayValue) {
//        this.displayValue = displayValue;
//    }
//
//    public String getDisplayValue() {
//        return displayValue;
//    }

    private String nombre;

    private Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}