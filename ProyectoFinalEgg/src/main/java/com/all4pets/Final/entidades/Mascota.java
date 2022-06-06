package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Edad;
import com.all4pets.Final.entidades.enumeraciones.Estado;
import com.all4pets.Final.entidades.enumeraciones.Genero;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Mascota {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne
    private Imagen imagen;
    private String tipo; //Clase de animal, ya sea perro, gato, pato, lo que sea
    private String observacion;
    @Enumerated (EnumType.STRING)
    private Estado estado; //Cómo se encuentra esa mascota 
    @Enumerated (EnumType.STRING)
    private Edad edad; //Edad de la mascota, ya sea, cachorro, adulto
    @Enumerated (EnumType.STRING)
    private Genero genero; //Género de la mascota, o sea macho o hembra
    private Boolean alta;
    
}