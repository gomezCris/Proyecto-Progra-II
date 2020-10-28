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

public class mdDetailsModel {
    int mdDetails_id;
    int md_id;
    String mdDetails_systomp;
    int medicine_id;
    String mdDetails_dose;

    public mdDetailsModel() {
    }

    public mdDetailsModel(int mdDetails_id, int md_id, String mdDetails_systomp, int medicine_id, String mdDetails_dose) {
        this.mdDetails_id = mdDetails_id;
        this.md_id = md_id;
        this.mdDetails_systomp = mdDetails_systomp;
        this.medicine_id = medicine_id;
        this.mdDetails_dose = mdDetails_dose;
    }

    public int getMdDetails_id() {
       return this.mdDetails_id;
    }

    public void setMdDetails_id(int mdDetails_id) {
        this.mdDetails_id = mdDetails_id;
    }

    public int getMd_id() {
       return this.md_id;
    }

    public void setMd_id(int md_id) {
        this.md_id = md_id;
    }

    public String getMdDetails_systomp() {
       return this.mdDetails_systomp;
    }

    public void setMdDetails_systomp(String mdDetails_systomp) {
        this.mdDetails_systomp = mdDetails_systomp;
    }

    public int getMedicine_id() {
       return this.medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMdDetails_dose() {
       return this.mdDetails_dose;
    }

    public void setMdDetails_dose(String mdDetails_dose) {
        this.mdDetails_dose = mdDetails_dose;
    }
    
}
