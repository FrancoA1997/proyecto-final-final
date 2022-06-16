package com.all4pets.Final.controladores;

import com.all4pets.Final.enumeraciones.Estado;
import com.all4pets.Final.enumeraciones.Sexo;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/logout")
    public String logout() {
        return "index.html";
    }
    
    @PostMapping("registro")
    public String registro(ModelMap modelo, @RequestParam String nombre, @RequestParam String email, @RequestParam String pswd) throws ExcepcionPropia {

        try {
            usuarioServicio.registrar(nombre, email, pswd);
        } catch (ExcepcionPropia e) {
            modelo.put("error", e.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            modelo.put("pswd", pswd);
        }

        modelo.put("exito", "Registrado con éxito");
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("perfil")
    public String perfil(@RequestParam String id) {
        
        return "perfil.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("modificar")
    public String formulario(ModelMap modelo) {
        modelo.addAttribute("sexo", Sexo.values());
        return "perfil.html";
    }
    
    @PostMapping("modificar")
    public String modificar(ModelMap modelo, @RequestParam String id, @RequestParam Sexo sexo, @RequestParam Integer edad, @RequestParam String telefono, @RequestParam String direccion) throws ExcepcionPropia {

        try {
            usuarioServicio.modificar(id, sexo, edad, telefono, direccion);
        } catch (ExcepcionPropia e) {
            modelo.put("error", e.getMessage());
            modelo.put("sexo", sexo);
            modelo.put("edad", edad);
            modelo.put("telefono", telefono);
            modelo.put("direccion", direccion);
        }

        modelo.put("exito", "Modificacion realizada con éxito");
        return "perfil.html";
    }
    
    @PostMapping("actualizarImagen")
    public String actualizarImagen(ModelMap modelo, MultipartFile archivo, @RequestParam String id) throws ExcepcionPropia {
        
        try {
            usuarioServicio.actualizarImagen(id, archivo);
        } catch (ExcepcionPropia e) {
            modelo.put("error", e.getMessage());
        }
        
        modelo.put("exito", "Imagen actualizada correctamente");
        return "perfil.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("cargarMascota")
    public String cargarMascota(ModelMap model) {
        
       
       model.addAttribute("estado", Estado.values());

        return "CargarMascota.html";
    }
    

}