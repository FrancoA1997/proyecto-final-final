
package com.all4pets.Final.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota {
    
    @Id
    private String id;
    @OneToOne
    private Imagen imagen;
    private String tipo; //Clase de animal, ya sea perro, gato, pato, lo que sea
    private String observacion;
    private Edad edad; //Edad de la mascota, ya sea, cachorro, adulto
    private Genero genero; //Género de la mascota, o sea macho o hembra
    private Boolean alta; 
    
    
    
    
}
