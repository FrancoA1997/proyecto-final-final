package com.all4pets.Final.controladores;

import com.all4pets.Final.entidades.Imagen;
import com.all4pets.Final.entidades.Mascota;
import com.all4pets.Final.entidades.Usuario;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.servicios.MascotaServicio;
import com.all4pets.Final.servicios.UsuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private MascotaServicio mascotaServicio;

    @GetMapping("/usuario")
    public ResponseEntity<byte[]> imagenUsuario(String id) throws ExcepcionPropia {
        try {
            Usuario usuario = usuarioServicio.buscarPorId(id);
            if (usuario.getImagen() == null) {
                throw new ExcepcionPropia("El usuario no tiene foto asignada");
            }
            byte[] imagen = usuario.getImagen().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        } catch (ExcepcionPropia e) {
            Logger.getLogger(ImagenControlador.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/mascota")
    public ResponseEntity<byte[]> imagenMascota(String id) throws ExcepcionPropia {
        try {
            Mascota mascota = mascotaServicio.buscarPorId(id);
            if (mascota.getImagen() == null) {
                throw new ExcepcionPropia("El usuario no tiene foto asignada");
            }
            byte[] imagen = mascota.getImagen().getContenido();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        } catch (ExcepcionPropia e) {
            Logger.getLogger(ImagenControlador.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
