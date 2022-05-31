
package com.all4pets.Final.entidades.enumeraciones.repositorios;

import com.all4pets.Final.entidades.Usuario;


public class UsuarioServicio {
    public void crearUsuario(String nombre, String email, String contraseña){
        Usuario u1 = new Usuario();
        u1.setNombre(nombre);
        u1.setContraseña(contraseña);
        u1.setEmail(email);
        
    }
}
