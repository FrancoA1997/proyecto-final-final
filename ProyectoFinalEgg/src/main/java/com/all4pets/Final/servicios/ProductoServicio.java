package com.all4pets.Final.servicios;

import com.all4pets.Final.entidades.Producto;
import com.all4pets.Final.enumeraciones.Tipo;
import com.all4pets.Final.repositorios.ProductoRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    
    @Autowired
    private ProductoRepositorio productoRepo;
    
    @Transactional
    public void crearProducto(String Id, Tipo tipo, Integer precio, Boolean stock, String descripcion){
        
        Producto p1 = new Producto();
        p1.setTipo(tipo);
        p1.setPrecio(precio);
        p1.setStock(stock);
        p1.setDescripcion(descripcion);
        
        productoRepo.save(p1);
        
    }
}