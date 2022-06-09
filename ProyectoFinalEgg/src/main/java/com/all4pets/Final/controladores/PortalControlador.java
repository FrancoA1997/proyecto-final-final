package com.all4pets.Final.controladores;

import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {
    
 
   @GetMapping("/index")
   public String index(){
       return "index.html";
   }
   
     @GetMapping("logeado")
    public String logeado() {
        return "iL.html";
    }
}