
package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Rol;
import com.all4pets.Final.entidades.enumeraciones.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated (EnumType.STRING)
    private Sexo sexo;
    private int edad;
    @OneToMany
    private List<Mascota> mascota;
    private String email;
    private String contraseña;
    private String telefono;
    private String direccion;
    private Boolean alta;
    
      @Enumerated (EnumType.STRING)
      private Rol rol;
    
}
