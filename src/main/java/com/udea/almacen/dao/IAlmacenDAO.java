/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.almacen.dao;

import com.udea.almacen.model.Almacen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego
 */
@Repository
public interface IAlmacenDAO extends CrudRepository<Almacen, Long> {
    
}
