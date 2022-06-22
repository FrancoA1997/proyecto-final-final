package com.all4pets.Final.controladores;

import com.all4pets.Final.entidades.Mascota;
import com.all4pets.Final.entidades.Producto;
import com.all4pets.Final.repositorios.ProductoRepositorio;
import com.all4pets.Final.servicios.MascotaServicio;
import com.all4pets.Final.servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    MascotaServicio mascotaServicio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    ProductoRepositorio productoRepo;

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

    @GetMapping("carrito")
    public String carrito(HttpSession session, ModelMap model) {
        List<Producto> productosCarrito = (List<Producto>) session.getAttribute("carrito");
        model.addAttribute("productosCarrito", productosCarrito);
        return "carrito.html";
    }

    @PostMapping("cart")
    public String tienda(@RequestParam String productoId, ModelMap model, HttpSession session) {
        Producto producto = productoRepo.findProductById(productoId);

        if ((List<Producto>) session.getAttribute("carrito") == null) {
            List<Producto> productos = new ArrayList();
            productos.add(producto);
            session.setAttribute("carrito", productos);
        } else {
            List<Producto> productos = (List<Producto>) session.getAttribute("carrito");
            productos.add(producto);
            session.setAttribute("carrito", productos);
        }
        
        return "tienda.html";
    }

    @GetMapping("adopciones")
    public String adopciones(Model model) {
        List<Mascota> listMascota = mascotaServicio.listaMascota();
        model.addAttribute("mascota", listMascota);

        return "adopcionesFix.html";
    }

}
