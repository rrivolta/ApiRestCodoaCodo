package com.codoacodo.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
public class Producto {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private Double precio;

public Producto() {
}
public Producto(Long id, String nombre, Double precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
}


public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public Double getPrecio() {
    return precio;
}
public void setPrecio(Double precio) {
    this.precio = precio;
}



}
