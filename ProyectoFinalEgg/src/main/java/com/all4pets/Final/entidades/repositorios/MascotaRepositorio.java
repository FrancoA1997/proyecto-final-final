package com.all4pets.Final.entidades.repositorios;

import com.all4pets.Final.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepositorio extends JpaRepository<Mascota, String> {
    
    
}