
package com.hospitalcm.model;

/**
 *
 * @author Liz
 */
public class PermisosModel {
    
    //Declaración de variables
    int permission_Id;
    int role_id;
    int module_id;
    boolean permission_create;
    boolean permission_read;
    boolean permission_update;
    boolean permission_delete;
 
   //Creación de constructores

    public PermisosModel() {
    }

    public PermisosModel(int permission_Id, int role_id, int module_id, boolean permission_create, boolean permission_read, boolean permission_update, boolean permission_delete) {
        this.role_id = role_id;
        this.module_id = module_id;
        this.permission_create = permission_create;
        this.permission_read = permission_read;
        this.permission_update = permission_update;
        this.permission_delete = permission_delete;
        this.permission_Id = permission_Id;
    }

    public int getPermission_Id() {
        return permission_Id;
    }

    public void setPermission_Id(int permission_Id) {
        this.permission_Id = permission_Id;
    }

    
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }



    public int getModule_id() {
        return this.module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public boolean isPermission_create() {
        return this.permission_create;
    }

    public void setPermission_create(boolean permission_create) {
        this.permission_create = permission_create;
    }

    public boolean isPermission_read() {
        return this.permission_read;
    }

    public void setPermission_read(boolean permission_read) {
        this.permission_read = permission_read;
    }

    public boolean isPermission_update() {
        return this.permission_update;
    }

    public void setPermission_update(boolean permission_update) {
        this.permission_update = permission_update;
    }

    public boolean isPermission_delete() {
        return this.permission_delete;
    }

    public void setPermission_delete(boolean permission_delete) {
        this.permission_delete = permission_delete;
    }
    
    
    
}
