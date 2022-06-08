package com.all4pets.Final.enumeraciones;

public enum Genero {
    MACHO("MACHO"),
    HEMBRA("HEMRBA");

    private String genero;

    private Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }
}
