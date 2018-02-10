/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controllers;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.dao.UserFacadeLocal;
import org.dto.User;

/**
 *
 * @author David
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    @EJB
    private UserFacadeLocal userFacadeLocal;
    private User user;
    private String name,
            password;

    public Login() {

    }

    @PostConstruct
    public void init() {

    }

    public String validateUser() {
        System.out.println(password);
        user = userFacadeLocal.validateUser(name, password);
        if (user != null) {
            return "dashboard/index.xhtm?faces-redirect=true";
        } else {
            return "";

        }
    }

    public void logOut() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();
        this.password = "";
        this.name = "";
        this.user = null;

        try {
            ec.redirect(ec.getRequestContextPath() + "/login.xhtml?faces-redirect=true");

        } catch (IOException ex) {
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void validateSession() {
        if (!isValidate()) {
            logOut();

        }

    }

    public boolean isValidate() {
        if (user != null) {
            return true;

        }
        return false;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}