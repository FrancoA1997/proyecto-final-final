package com.all4pets.Final.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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