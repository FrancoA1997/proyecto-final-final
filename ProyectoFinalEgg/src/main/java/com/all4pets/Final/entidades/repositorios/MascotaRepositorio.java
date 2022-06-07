package com.all4pets.Final.entidades.repositorios;

import com.all4pets.Final.entidades.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepositorio extends JpaRepository<Mascota, String> {
    
//    @Query("SELECT a FROM Mascota a WHERE a.usuario.id = :id")
//    public List<Mascota> buscarMascotasPorUsuario(@Param("id") String id);
//  
    
}