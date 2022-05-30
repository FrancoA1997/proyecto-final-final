
package com.all4pets.Final.entidades;

import javax.persistence.Id;
import lombok.Data;

@Data
public class Usuario {
  @Id  
    private String id;
    private String nombreYapellido;
    private int edad;
    private Mascota mascota;
    private String email;
    private String contraseña;
    private String telefono;
    private String direccion;
    private Boolean alta;
    
}
