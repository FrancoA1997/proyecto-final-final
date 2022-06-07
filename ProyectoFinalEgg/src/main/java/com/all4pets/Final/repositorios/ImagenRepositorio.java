package com.all4pets.Final.repositorios;

import com.all4pets.Final.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, String> {
    
    
}