/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.dto.User;

/**
 *
 * @author David
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "org_EjemploMaven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User validateUser(String name, String password) {
        User user = null;
        
        try {
            TypedQuery<User> q = getEntityManager().createNamedQuery("User.login", User.class);
            q.setParameter("name", name);
            q.setParameter("password", password);
            System.out.println(password);
            user = q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user;
        
    }
    
}
