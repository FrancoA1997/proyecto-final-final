package com.all4pets.Final.enumeraciones;


public enum Tipo {
    
    ALIMENTO("ALIMENTO"),
    ACCESORIOS("ACCESORIOS"),
    JUGUETES("JUGUETES"),
    MEDICAMENTOS("MEDICAMENTOS");
    
    private String tipo;

   private Tipo(String estado) {
        this.tipo = estado;
    }
    public String getTipo() {
        return tipo;
    }

   
   
}
