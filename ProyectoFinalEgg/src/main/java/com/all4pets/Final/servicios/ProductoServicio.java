package com.all4pets.Final.servicios;

import com.all4pets.Final.entidades.Producto;
import com.all4pets.Final.enumeraciones.Tipo;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.repositorios.ProductoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    
    @Autowired
    private ProductoRepositorio productoRepo;
    
    @Transactional
    public void crearProducto(String Id, Tipo tipo, Integer precio, Boolean stock, String descripcion) throws ExcepcionPropia {
        
        validar(tipo, precio, stock, descripcion);
        
        Producto p1 = new Producto();
        
        p1.setTipo(tipo);
        p1.setPrecio(precio);
        p1.setStock(stock);
        p1.setDescripcion(descripcion);
        
        productoRepo.save(p1);
        
}
    public void bajaStock(String id) throws ExcepcionPropia {

        Optional<Producto> respuesta = productoRepo.findById(id);
        if (respuesta.isPresent()) {
            Producto producto = respuesta.get();
            producto.setStock(Boolean.FALSE);
            productoRepo.save(producto);
        } else {
            throw new ExcepcionPropia("No se encontro el producto solicitado");
        }
    }
    
    public void borrarProducto(String Id) {
        Optional<Producto> respuesta = productoRepo.findById(Id);

        if (respuesta.isPresent()) {
            productoRepo.delete(respuesta.get());
        }
    }
    
    private void validar(Tipo tipo, Integer precio, Boolean stock, String descripcion) throws ExcepcionPropia {

        if (tipo == null ) {
            throw new ExcepcionPropia("Por favor, indique el tipo de producto");
        }

        if (precio == null ) {
            throw new ExcepcionPropia("Por favor, indique el precio del producto");
        }

        if (stock == null ) {
            throw new ExcepcionPropia("Por favor, indique si el producto se encuentra en stock");
        }
        
        if (descripcion == null ) {
            throw new ExcepcionPropia("Por favor, indique al menos una breve desripcion del producto");
        }

    }
}
