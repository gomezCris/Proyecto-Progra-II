
package com.hospitalcm.model;

/**
 *
 * @author Liz
 */

public class EspecialistasModel {
    
   //Declaración de variables
    int speciality_id;
    String speciality_name;
    String speciality_description;
    
    //Creación de constructores

    public EspecialistasModel() {
    }

    public EspecialistasModel(int speciality_id, String speciality_name, String speciality_description) {
        this.speciality_id = speciality_id;
        this.speciality_name = speciality_name;
        this.speciality_description = speciality_description;
    }

    
    public int getSpeciality_id() {
        return this.speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    public String getSpeciality_name() {
        return this.speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }

    public String getSpeciality_description() {
        return this.speciality_description;
    }

    public void setSpeciality_description(String speciality_description) {
        this.speciality_description = speciality_description;
    }
    
    
}
