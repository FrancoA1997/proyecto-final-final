
package com.all4pets.Final.controladores;

import com.all4pets.Final.entidades.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
   @Autowired
   private UsuarioServicio usuarioServicio;

   @GetMapping("")
   public String index(){
       return "index.html";
   }
    @GetMapping("login")
    public String login() {
        return "login.html";
    }
    @PostMapping("registro")
    public  String Registro(@RequestParam String nombre,@RequestParam String email, @RequestParam String pswd ){
       usuarioServicio.crearUsuario(nombre, email, nombre);

        return "login.html";
    }

}
