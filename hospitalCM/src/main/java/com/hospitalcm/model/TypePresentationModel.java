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

public class TypePresentationModel {
    int tp_id;
    String tp_name;
    String tp_description;
    boolean active;

    public TypePresentationModel() {
    }

    public TypePresentationModel(int tp_id, String tp_name, String tp_description, boolean active) {
        this.tp_id = tp_id;
        this.tp_name = tp_name;
        this.tp_description = tp_description;
        this.active = active;
    }

    public int getTp_id() {
        return this.tp_id;
    }

    public void setTp_id(int tp_id) {
        this.tp_id = tp_id;
    }

    public String getTp_name() {
        return this.tp_name;
    }

    public void setTp_name(String tp_name) {
        this.tp_name = tp_name;
    }

    public String getTp_description() {
        return this.tp_description;
    }

    public void setTp_description(String tp_description) {
        this.tp_description = tp_description;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
