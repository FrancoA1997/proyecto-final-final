
package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Sexo sexo;
    private int edad;
    @OneToMany
    private List<Mascota> mascota;
    private String email;
    private String contraseña;
    private String telefono;
    private String direccion;
    private Boolean alta;
    
}
