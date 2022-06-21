package com.all4pets.Final.entidades;

import com.all4pets.Final.enumeraciones.Rol;
import com.all4pets.Final.enumeraciones.Sexo;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    private Imagen imagen;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    private Integer edad;
    
    @OneToOne
    private Mascota mascota;
    
    @Column(unique = true)
    private String email;
    
    @Column(nullable = false)
    private String clave;
    
    private String telefono;
    private String direccion;
    private Boolean alta;

    @Enumerated(EnumType.STRING)
    private Rol rol;

}