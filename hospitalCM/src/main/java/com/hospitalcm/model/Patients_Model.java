
package com.hospitalcm.model;

import java.sql.Date;

/**
 *
 * @author Liz
 */

public class Patients_Model {
    
   //Declaración de variables
   int patient_id; 
   Date patient_startdate; 
   String patient_username; 
   String patient_password; 
   Date patient_stopdate; 
   boolean patient_active; 
   int user_id;
   
    //Creación de constructores

    public Patients_Model() {
    }

    public Patients_Model(int patient_id, Date patient_startdate, String patient_username, String patient_password, Date patient_stopdate, boolean patient_active, int user_id) {
        this.patient_id = patient_id;
        this.patient_startdate = patient_startdate;
        this.patient_username = patient_username;
        this.patient_password = patient_password;
        this.patient_stopdate = patient_stopdate;
        this.patient_active = patient_active;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getPatient_startdate() {
        return this.patient_startdate;
    }

    public void setPatient_startdate(Date patient_startdate) {
        this.patient_startdate = patient_startdate;
    }

    public String getPatient_username() {
        return this.patient_username;
    }

    public void setPatient_username(String patient_username) {
        this.patient_username = patient_username;
    }

    public String getPatient_password() {
        return this.patient_password;
    }

    public void setPatient_password(String patient_password) {
        this.patient_password = patient_password;
    }

    public Date getPatient_stopdate() {
        return this.patient_stopdate;
    }

    public void setPatient_stopdate(Date patient_stopdate) {
        this.patient_stopdate = patient_stopdate;
    }

    public boolean isPatient_active() {
        return this.patient_active;
    }

    public void setPatient_active(boolean patient_active) {
        this.patient_active = patient_active;
    }
   
   
   
}
