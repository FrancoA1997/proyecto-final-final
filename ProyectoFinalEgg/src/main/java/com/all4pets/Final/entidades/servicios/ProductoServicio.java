
package com.all4pets.Final.entidades.servicios;

import com.all4pets.Final.entidades.Producto;
import com.all4pets.Final.entidades.enumeraciones.Tipo;
import com.all4pets.Final.entidades.repositorios.ProductoRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepo;
    @Transactional
    public void crearProducto(String Id, Tipo tipo, int precio, boolean stock, String descripcion){
        Producto p1 = new Producto();
        p1.setTipo(tipo);
        p1.setPrecio(precio);
        p1.setStock(stock);
        p1.setDescripcion(descripcion);
        
        productoRepo.save(p1);
        
    }
}
