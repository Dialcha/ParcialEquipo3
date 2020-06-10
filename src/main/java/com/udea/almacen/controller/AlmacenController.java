/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.almacen.controller;

import com.udea.almacen.exception.ModelNotFoundException;
import com.udea.almacen.model.Almacen;
import com.udea.almacen.service.AlmacenService;
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
@Api(value = "Administración de productos y almacenes", description = "Sistema de manejo de productos y stock de almacenes")
public class AlmacenController {

    @Autowired
    AlmacenService almacenService;

    @ApiOperation(value = "Add a person")
    @PostMapping("/save")
    public long save(@ApiParam(value = "Employee object store in database table", required = true) @RequestBody Almacen almacen) {
        almacenService.save(almacen);
        return almacen.getIdAlmacen();
    }

    @ApiOperation(value = "Obtener lista de almacenes")
    @GetMapping("/listAllAlmacenes")
    public Iterable<Almacen> listAllAlmacenes(){return almacenService.list();}
    
    @ApiOperation(value = "Obtener un almacén por su id")
    @GetMapping("/listAlmacenes/{id}")
    public Almacen listAlmacenById(@ApiParam(value = "Id del almacen que será consultado", required = true) @PathVariable("id") int id) {
        Optional<Almacen> almacen = almacenService.listId(id);
        if (almacen.isPresent()) {
            return almacen.get();
        }
        throw new ModelNotFoundException("ID de almacén invalido");
    }
}