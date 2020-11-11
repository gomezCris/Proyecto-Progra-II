/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.model;

import java.sql.Date;

/**
 *
 * @author Denzil Barrios
 * GoDevs Team-2,020
 */

public class medicalConsultationModel {
    int mc_id;
    int mc_secretary_id;
    int mc_doctor_id;
    int patient_id;
    Date mc_appointment;
    boolean mc_confirmation;
    boolean active;

    public medicalConsultationModel() {
    }

    public medicalConsultationModel(int mc_id, int mc_secretary_id, int mc_doctor_id, int patient_id, Date mc_appointment, boolean mc_confirmation, boolean active) {
        this.mc_id = mc_id;
        this.mc_secretary_id = mc_secretary_id;
        this.mc_doctor_id = mc_doctor_id;
        this.patient_id = patient_id;
        this.mc_appointment = mc_appointment;
        this.mc_confirmation = mc_confirmation;
        this.active = active;
    }

    public int getMc_id() {
        return this.mc_id;
    }

    public void setMc_id(int mc_id) {
        this.mc_id = mc_id;
    }

    public int getMc_secretary_id() {
        return this.mc_secretary_id;
    }

    public void setMc_secretary_id(int mc_secretary_id) {
        this.mc_secretary_id = mc_secretary_id;
    }

    public int getMc_doctor_id() {
        return this.mc_doctor_id;
    }

    public void setMc_doctor_id(int mc_doctor_id) {
        this.mc_doctor_id = mc_doctor_id;
    }

    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getMc_appointment() {
        return this.mc_appointment;
    }

    public void setMc_appointment(Date mc_appointment) {
        this.mc_appointment = mc_appointment;
    }

    public boolean isMc_confirmation() {
        return this.mc_confirmation;
    }

    public void setMc_confirmation(boolean mc_confirmation) {
        this.mc_confirmation = mc_confirmation;
    }
    
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
