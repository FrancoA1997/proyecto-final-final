
package com.all4pets.Final.entidades.servicios;

import com.all4pets.Final.entidades.Usuario;
import com.all4pets.Final.entidades.repositorios.UsuarioRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
   @Autowired
   private UsuarioRepositorio usuarioRepo;
    @Transactional
    public void crearUsuario(String nombre, String email, String contraseña){
        Usuario u1 = new Usuario();
        u1.setNombre(nombre);
        u1.setContraseña(contraseña);
        u1.setEmail(email);
        usuarioRepo.save(u1);
    }
}
