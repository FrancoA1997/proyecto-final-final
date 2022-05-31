
package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Sexo;
import javax.persistence.Id;
import lombok.Data;

@Data
public class Usuario {
  @Id  
    private String id;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private Mascota mascota;
    private String email;
    private String contraseña;
    private String telefono;
    private String direccion;
    private Boolean alta;
    
}
