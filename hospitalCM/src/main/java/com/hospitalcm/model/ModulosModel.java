
package com.hospitalcm.model;

/**
 *
 * @author Liz
 */
public class ModulosModel {
    
    //Declaración de variables
    int module_id;
    String module_name;
    String module_description;
    
    //Creación de constructores

    public ModulosModel() {
    }

    public ModulosModel(int module_id, String module_name, String module_description) {
        this.module_id = module_id;
        this.module_name = module_name;
        this.module_description = module_description;
    }

    public int getModule_id() {
        return this.module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getModule_name() {
        return this.module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_description() {
        return this.module_description;
    }

    public void setModule_description(String module_description) {
        this.module_description = module_description;
    }
    
    
}
