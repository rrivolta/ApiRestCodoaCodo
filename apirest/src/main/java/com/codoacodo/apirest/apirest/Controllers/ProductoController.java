package com.codoacodo.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codoacodo.apirest.apirest.Entities.Producto;
import com.codoacodo.apirest.apirest.Repositories.ProductoRepository;



@RestController
@RequestMapping("/Producto")
public class ProductoController {

@Autowired

private ProductoRepository productoRepository;

@GetMapping
public List<Producto> obtenerProductos(){
return productoRepository.findAll();
}
 
@GetMapping("/{id}")
public Producto obtenerProductoPorId(@PathVariable Long id){
    return productoRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encuentra el producto con el id: " +id));

}
 
@PostMapping
public Producto crearProducto(@RequestBody Producto producto){
return productoRepository.save(producto);
}

@PutMapping
public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
Producto producto = productoRepository.findById(id)
.orElseThrow(() -> new RuntimeException("No se encuentra el producto con el id: " +id));

producto.setNombre(detallesProducto.getNombre());
producto.setPrecio(detallesProducto.getPrecio());

return productoRepository.save(producto);
}



@DeleteMapping("/{id}")
public String borrarProducto(@PathVariable Long id){
Producto producto = productoRepository.findById(id)
.orElseThrow(() -> new RuntimeException("No se encuentra el producto con el id: " +id));

productoRepository.delete(producto);
return "El producto con el id:" + id +"fue eliminado correctamente";

}
}