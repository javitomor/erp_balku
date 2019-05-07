/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author javiermoreno
 */
public class ModelController {
    
    private EntityManagerFactory emf;
    private EntityManager manager;
    
    public void ModelController(){}
    public EntityManager createEntities(){
        
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
        
        return manager;
        
    }
}
