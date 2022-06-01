/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.all4pets.Final.entidades;

import com.all4pets.Final.entidades.enumeraciones.Tipo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
@Data 
@Entity
public class Producto {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
   private String Id;
   private Tipo tipo;
   private int precio;
   private boolean Stock;
   private String Descripcion;
    
}
