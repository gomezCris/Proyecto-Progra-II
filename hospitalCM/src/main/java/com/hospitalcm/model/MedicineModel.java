/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.model;

/**
 *
 * @author Denzil Barrios
 * GoDevs Team-2,020
 */

public class MedicineModel {
    int medicine_id;
    int tp_id;
    double medicine_costPrice;
    double medicine_costSale;
    int medicine_existence;
    boolean active;
    
    public MedicineModel() {
    }

    public MedicineModel(int medicine_id, int tp_id, double medicine_costPrice, double medicine_costSale, int medicine_existence, boolean active) {
        this.medicine_id = medicine_id;
        this.tp_id = tp_id;
        this.medicine_costPrice = medicine_costPrice;
        this.medicine_costSale = medicine_costSale;
        this.medicine_existence = medicine_existence;
        this.active = active;
    }

    public int getMedicine_id() {
        return this.medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getTp_id() {
        return this.tp_id;
    }

    public void setTp_id(int tp_id) {
        this.tp_id = tp_id;
    }

    public double getMedicine_costPrice() {
        return this.medicine_costPrice;
    }

    public void setMedicine_costPrice(double medicine_costPrice) {
        this.medicine_costPrice = medicine_costPrice;
    }

    public double getMedicine_costSale() {
        return this.medicine_costSale;
    }

    public void setMedicine_costSale(double medicine_costSale) {
        this.medicine_costSale = medicine_costSale;
    }

    public int getMedicine_existence() {
        return this.medicine_existence;
    }

    public void setMedicine_existence(int medicine_existence) {
        this.medicine_existence = medicine_existence;
    }
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
