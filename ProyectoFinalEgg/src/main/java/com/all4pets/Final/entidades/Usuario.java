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
    
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    private Integer edad;
    
    @OneToMany
    private List<Mascota> mascota;
    
    @Column(unique = true)
    private String email;
    
    private String clave;
    private String telefono;
    private String direccion;
    private Boolean alta;

    @Enumerated(EnumType.STRING)
    private Rol rol;

}