
package com.udea.almacen.controller;

import com.udea.almacen.exception.ModelNotFoundException;
import com.udea.almacen.model.Producto;
import com.udea.almacen.service.ProductoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
@Api(value = "Administración de productos", description = "crud de productos")
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @ApiOperation(value = "Añadir un producto")
    @PostMapping("/saveProducto")
    public long save(@ApiParam(value = "Producto que será añadido a la bd", required = true) @RequestBody Producto producto) {
        productoService.save(producto);
        return producto.getIdProducto();
    }

    @ApiOperation(value = "Obtener lista de productos")
    @GetMapping("/listAllProductos")
    public Iterable<Producto> listAllProductos(){return productoService.list();}
    
    @ApiOperation(value = "Obtener un producto por su id")
    @GetMapping("/listProductos/{id}")
    public Producto listProductoById(@ApiParam(value = "Id del producto que será consultado", required = true) @PathVariable("id") int id) {
        Optional<Producto> producto = productoService.listId(id);
        if (producto.isPresent()) {
            return producto.get();
        }
        throw new ModelNotFoundException("ID de producto invalido");
    }
    
}
