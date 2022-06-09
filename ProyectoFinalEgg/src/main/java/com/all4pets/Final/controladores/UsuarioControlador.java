package com.all4pets.Final.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("")
public class UsuarioControlador {
    
   @GetMapping("registro")
    public String crearUsuario() {
        return "login.html";
    } 
}
