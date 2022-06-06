package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Tipo;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    
    @OneToOne
    private Imagen imagen;
    
    private int precio;
    private boolean stock;
    private String descripcion;

}