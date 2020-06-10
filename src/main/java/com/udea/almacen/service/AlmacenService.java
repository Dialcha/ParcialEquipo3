/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.almacen.service;

import com.udea.almacen.dao.IAlmacenDAO;
import com.udea.almacen.model.Almacen;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class AlmacenService {

    @Autowired
    private IAlmacenDAO daoAlmacen;

    public Almacen save(Almacen t) {
        return daoAlmacen.save(t);
    }

    public Almacen update(Almacen t) {
        return daoAlmacen.save(t);
    }

    public void delete(Almacen t) {
        daoAlmacen.delete(t);
    }

    public Iterable<Almacen> list() {
        return daoAlmacen.findAll();
    }

    public Optional<Almacen> listId(long id) {
        return daoAlmacen.findById(id);
    }
}
