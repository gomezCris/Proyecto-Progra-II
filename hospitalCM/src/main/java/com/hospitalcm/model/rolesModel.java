package com.hospitalcm.model;

/**
 *
 * @author Liz 
 */

public class rolesModel {
    //Declaración de variables
    int rolId;
    String rolName;
    String rolDescription;
    boolean rolActive;
    
    //Creación de constructores
    public rolesModel() {
    }

    public rolesModel(int rolId, String rolName, String rolDescription, boolean rolActive) {
        this.rolId = rolId;
        this.rolName = rolName;
        this.rolDescription = rolDescription;
        this.rolActive = rolActive;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
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
    
    
    
}
