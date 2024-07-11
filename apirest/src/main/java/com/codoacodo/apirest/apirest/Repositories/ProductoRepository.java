package com.codoacodo.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codoacodo.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    

}
