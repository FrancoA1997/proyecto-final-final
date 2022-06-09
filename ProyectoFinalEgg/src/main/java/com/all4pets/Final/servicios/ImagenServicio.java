package com.all4pets.Final.servicios;

import com.all4pets.Final.entidades.Imagen;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.all4pets.Final.repositorios.ImagenRepositorio;

@Service
public class ImagenServicio {
    
    @Autowired
    private ImagenRepositorio imagenRepo;
    
    @Transactional
    public Imagen multiPartToEntity(MultipartFile archivo) throws ExcepcionPropia {
        
        if(archivo != null) {
            Imagen imagen = new Imagen();
            imagen.setMime(archivo.getContentType());
            imagen.setNombre(archivo.getName());
            try {
                imagen.setContenido(archivo.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(ImagenServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            return imagenRepo.save(imagen);
        } else {
            throw new ExcepcionPropia("No se puede cargar la foto");
        }
        
    }
    
// METODO PARA CAMBIAR 'SOLO' LA FOTO DE PERFIL DEL USUARIO O MASCOTA (TO DO)
    
//    public Imagen actualizar(String idImagen, MultipartFile archivo) throws ExcepcionPropia {
//        
//        if(archivo != null) {
//            Imagen imagen = new Imagen();
//            if(idImagen != null) {
//                Optional<Imagen> respuesta = imagenRepo.findById(idImagen);
//                if(respuesta.isPresent()) {
//                    imagen = respuesta.get();
//                }
//            }
//            imagen.setMime(archivo.getContentType());
//            imagen.setNombre(archivo.getName());
//            try {
//                imagen.setContenido(archivo.getBytes());
//            } catch (IOException ex) {
//                Logger.getLogger(ImagenServicio.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return imagenRepo.save(imagen);
//        } else {
//            throw new ExcepcionPropia("No se puede cargar la foto");
//        }
//        
//    }
}