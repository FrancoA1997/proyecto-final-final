package com.all4pets.Final.servicios;

import com.all4pets.Final.entidades.Imagen;
import com.all4pets.Final.entidades.Mascota;
import com.all4pets.Final.enumeraciones.Edad;
import com.all4pets.Final.enumeraciones.Estado;
import com.all4pets.Final.enumeraciones.Genero;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.repositorios.MascotaRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MascotaServicio {

    @Autowired
    private MascotaRepositorio mascotaRepo;

    @Autowired
    private ImagenServicio imagenServicio;

    @Transactional
    public Mascota registrar(String tipo, String observacion, Estado estado, Edad edad, Genero genero, Boolean estaActivo, MultipartFile archivo) throws ExcepcionPropia {
        validar(tipo, observacion, estado, edad, genero);
        Mascota mascota = new Mascota();
        mascota.setTipo(tipo);
        mascota.setObservacion(observacion);
        mascota.setEstado(estado);
        mascota.setEdad(edad);
        mascota.setGenero(genero);
        mascota.setAlta(estaActivo);
        Imagen imagen = imagenServicio.multiPartToEntity(archivo);
        mascota.setImagen(imagen);

        return mascotaRepo.save(mascota);
    }

    public void validar(String tipo, String observacion, Estado estado, Edad edad, Genero genero) throws ExcepcionPropia {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ExcepcionPropia("Por favor, indique el tipo de mascota");
        }

        if (observacion == null || tipo.trim().isEmpty()) {
            throw new ExcepcionPropia("Por favor, indique las observaciones para su mascota");
        }
        if (estado == null || estado.toString().trim().isEmpty()) {
            throw new ExcepcionPropia("Este campo no puede estar vacío. Por favor, elija una opción");
        }
        if (edad == null || edad.toString().trim().isEmpty()) {
            throw new ExcepcionPropia("Este campo no puede estar vacío. Por favor, elija una opción");
        }
        if (genero == null || genero.toString().trim().isEmpty()) {
            throw new ExcepcionPropia("Este campo no puede estar vacío. Por favor, elija una opción");
        }
    }

    public void deshabilitar(String id) throws ExcepcionPropia {

        Optional<Mascota> respuesta = mascotaRepo.findById(id);
        if (respuesta.isPresent()) {
            Mascota mascota = respuesta.get();
            mascota.setAlta(Boolean.FALSE);
            mascotaRepo.save(mascota);
        } else {
            throw new ExcepcionPropia("No se encontro la mascota solicitada");
        }
    }

    public void habilitar(String id) throws ExcepcionPropia {

        Optional<Mascota> respuesta = mascotaRepo.findById(id);
        if (respuesta.isPresent()) {
            Mascota mascota = respuesta.get();
            mascota.setAlta(Boolean.TRUE);
            mascotaRepo.save(mascota);
        } else {
            throw new ExcepcionPropia("No se encontro el usuario solicitado");
        }
    }
}
