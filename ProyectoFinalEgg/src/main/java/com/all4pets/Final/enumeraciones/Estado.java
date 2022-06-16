package com.all4pets.Final.enumeraciones;

public enum Estado {

    PERDIDO("PERDIDO"),
    ADOPCION("ADOPCIÓN");

   private final String displayValue;

    private Estado(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
