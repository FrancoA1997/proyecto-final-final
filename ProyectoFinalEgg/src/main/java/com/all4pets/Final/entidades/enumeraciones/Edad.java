
package com.all4pets.Final.entidades.enumeraciones;


public enum Edad {
    
    ADULTO("ADULTO"),
    MEDIANO("MEDIANO"),
    CACHORRO("CACHORRO");
    
    private String edad;

    private Edad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return this.edad;
    }
    
}
