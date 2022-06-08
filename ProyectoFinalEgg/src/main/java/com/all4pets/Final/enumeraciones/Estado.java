package com.all4pets.Final.enumeraciones;

public enum Estado {

    PERDIDO("PERDIDO"),
    ADOPCION("ADOPCIÓN");

    private String estado;

    private Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

}
