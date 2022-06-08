
package com.all4pets.Final.enumeraciones;


public enum Sexo {
    FEMENINO("FEMENINO"),
    MASCULINO("MASCULINO");

    private String sexo;

    private Sexo(String genero) {
        this.sexo = genero;
    }

    public String getGenero() {
        return this.sexo;
    }
    
}
