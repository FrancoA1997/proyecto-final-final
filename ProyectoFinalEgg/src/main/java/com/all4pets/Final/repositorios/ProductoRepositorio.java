package com.all4pets.Final.repositorios;

import com.all4pets.Final.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
    @Query("SELECT u FROM Producto u WHERE u.id = :id")
   public Producto findProductById(@Param("id") String id);

   
    
}