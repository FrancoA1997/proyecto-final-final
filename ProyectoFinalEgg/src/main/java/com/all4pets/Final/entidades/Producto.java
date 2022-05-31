/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Tipo;
import javax.persistence.Id;
import lombok.Data;
@Data 
public class Producto {
    @Id
    String Id;
    Tipo tipo;
    int precio;
    boolean Stock;
    String Descripcion;
    
}
