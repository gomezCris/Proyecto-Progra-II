
package com.hospitalcm.model;

import java.sql.Date;

/**
 *
 * @author Liz
 */

public class EmployeesModel {
    
    //Declaración de variables
    int employees_id;
    Date employees_startDate;
    float employees_salary;
    String employees_positionTitle;
    String employees_username;
    String employees_password;
    Date employees_stopDate;
    boolean  employees_active;
    int user_id;
    int speciality_id;
    int role_id;
    Date employees_register;
    boolean active;
    
    
    //Creación de constructores

    public EmployeesModel() {
    }

    public EmployeesModel(int employees_id, Date employees_startDate, float employees_salary, String employees_positionTitle, String employees_username, String employees_password, Date employees_stopDate, boolean employees_active, int user_id, int speciality_id, int role_id, Date employees_register, boolean active) {
        this.employees_id = employees_id;
        this.employees_startDate = employees_startDate;
        this.employees_salary = employees_salary;
        this.employees_positionTitle = employees_positionTitle;
        this.employees_username = employees_username;
        this.employees_password = employees_password;
        this.employees_stopDate = employees_stopDate;
        this.employees_active = employees_active;
        this.user_id = user_id;
        this.speciality_id = speciality_id;
        this.role_id = role_id;
        this.employees_register = employees_register;
        this.active = active;
    }


    public int getSpeciality_id() {
        return this.speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

    public int getEmployees_id() {
        return this.employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public Date getEmployees_startDate() {
        return this.employees_startDate;
    }

    public void setEmployees_startDate(Date employees_startDate) {
        this.employees_startDate = employees_startDate;
    }

    public float getEmployees_salary() {
        return this.employees_salary;
    }

    public void setEmployees_salary(float employees_salary) {
        this.employees_salary = employees_salary;
    }

    public String getEmployees_positionTitle() {
        return this.employees_positionTitle;
    }

    public void setEmployees_positionTitle(String employees_positionTitle) {
        this.employees_positionTitle = employees_positionTitle;
    }

    public String getEmployees_username() {
        return this.employees_username;
    }

    public void setEmployees_username(String employees_username) {
        this.employees_username = employees_username;
    }

    public String getEmployees_password() {
        return this.employees_password;
    }

    public void setEmployees_password(String employees_password) {
        this.employees_password = employees_password;
    }

    public Date getEmployees_stopDate() {
        return this.employees_stopDate;
    }

    public void setEmployees_stopDate(Date employees_stopDate) {
        this.employees_stopDate = employees_stopDate;
    }

    public boolean isEmployees_active() {
        return this.employees_active;
    }

    public void setEmployees_active(boolean employees_active) {
        this.employees_active = employees_active;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Date getEmployees_register() {
        return employees_register;
    }

    public void setEmployees_register(Date employees_register) {
        this.employees_register = employees_register;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
