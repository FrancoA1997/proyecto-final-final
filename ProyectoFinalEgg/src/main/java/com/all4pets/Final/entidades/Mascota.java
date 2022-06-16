package com.all4pets.Final.entidades;

import com.all4pets.Final.enumeraciones.Estado;
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
    
    private Boolean alta;
    
}