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

public class MedicalDiagnosticModel {
    int md_id;
    int mc_id;
    String md_observations;
    Date md_beginTime;
    Date md_endTime;
    boolean active;

    public MedicalDiagnosticModel() {
    }

    public MedicalDiagnosticModel(int md_id, int mc_id, String md_observations, Date md_beginTime, Date md_endTime, boolean active) {
        this.md_id = md_id;
        this.mc_id = mc_id;
        this.md_observations = md_observations;
        this.md_beginTime = md_beginTime;
        this.md_endTime = md_endTime;
        this.active = active;
    }

    public int getMd_id() {
        return this.md_id;
    }

    public void setMd_id(int md_id) {
        this.md_id = md_id;
    }

    public int getMc_id() {
        return this.mc_id;
    }

    public void setMc_id(int mc_id) {
        this.mc_id = mc_id;
    }

    public String getMd_observations() {
        return this.md_observations;
    }

    public void setMd_observations(String md_observations) {
        this.md_observations = md_observations;
    }

    public Date getMd_beginTime() {
        return this.md_beginTime;
    }

    public void setMd_beginTime(Date md_beginTime) {
        this.md_beginTime = md_beginTime;
    }

    public Date getMd_endTime() {
        return this.md_endTime;
    }

    public void setMd_endTime(Date md_endTime) {
        this.md_endTime = md_endTime;
    }
    
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
