package com.hospitalcm.model;

import java.sql.Date;

/**
 *
 * @author Liz 
 */

public class rolesModel {
    //Declaración de variables
    int role_id;
    String rolName;
    String rolDescription;
    boolean rolActive;
    Date role_register;
    
    //Creación de constructores
    public rolesModel() {
    }

    public rolesModel(int role_id, String rolName, String rolDescription, boolean rolActive, Date role_register) {
        this.role_id = role_id;
        this.rolName = rolName;
        this.rolDescription = rolDescription;
        this.rolActive = rolActive;
        this.role_register = role_register;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }



    public String getRolName() {
        return this.rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getRolDescription() {
        return this.rolDescription;
    }

    public void setRolDescription(String rolDescription) {
        this.rolDescription = rolDescription;
    }

    public boolean isRolActive() {
        return this.rolActive;
    }

    public void setRolActive(boolean rolActive) {
        this.rolActive = rolActive;
    }

    public Date getRole_register() {
        return role_register;
    }

    public void setRole_register(Date role_register) {
        this.role_register = role_register;
    }
    
    
    
}
