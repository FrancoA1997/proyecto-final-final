package com.all4pets.Final.enumeraciones;

public enum Estado {

    PERDIDO("PERDIDO"),
    ADOPCION("ADOPCION");

    private String nombre;

    private Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}