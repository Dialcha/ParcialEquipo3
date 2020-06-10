
package com.udea.almacen.service;

import com.udea.almacen.dao.IProductoDAO;
import com.udea.almacen.model.Producto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class ProductoService {
    
    @Autowired
    private IProductoDAO daoProducto;

    public Producto save(Producto t) {return daoProducto.save(t);}
    public Producto update(Producto t) {return daoProducto.save(t);}public void delete(Producto t) {daoProducto.delete(t);}
    public Iterable<Producto> list() {return daoProducto.findAll();}
    public Optional<Producto> listId(long id) {return daoProducto.findById(id);}
}
