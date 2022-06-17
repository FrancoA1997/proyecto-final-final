package com.all4pets.Final.controladores;

import com.all4pets.Final.entidades.Producto;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Email o Clave incorrectos");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("inicio")
    public String inicio() {
        return "iL.html";
    }
@GetMapping("tienda")
    public String tienda() {
    
        return "tienda.html";
    }
    @GetMapping("tienda/{id}")
    public String tienda(@PathVariable String id, ModelMap model,HttpSession
request) {
//        List<Producto> carrito = new List();
        
        
        return "tienda.html";
    }

    @GetMapping("adopciones")
    public String adopciones() {
        return "adopciones.html";
    }

}