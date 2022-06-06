
package com.all4pets.Final.entidades.repositorios;

import com.all4pets.Final.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
   
    
}