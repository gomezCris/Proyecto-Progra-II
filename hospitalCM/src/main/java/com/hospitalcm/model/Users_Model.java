
package com.hospitalcm.model;

import java.sql.Date;

/**
 *
 * @author Liz
 */

public class Users_Model {
    
//Declaración de variables
    int user_id; 
    String user_firstname; 
    String user_lastname; 
    String user_email; 
    String user_phonenumber; 
    Date user_birthdate; 
    String user_address; 
    boolean user_active; 
    
  //Creación de constructores

    public Users_Model() {
    }

    public Users_Model(int user_id, String user_firstname, String user_lastname, String user_email, String user_phonenumber, Date user_birthdate, String user_address, boolean user_active) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_phonenumber = user_phonenumber;
        this.user_birthdate = user_birthdate;
        this.user_address = user_address;
        this.user_active = user_active;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstname() {
        return this.user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return this.user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return this.user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phonenumber() {
        return this.user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public Date getUser_birthdate() {
        return this.user_birthdate;
    }

    public void setUser_birthdate(Date user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public String getUser_address() {
        return this.user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public boolean isUser_active() {
        return this.user_active;
    }

    public void setUser_active(boolean user_active) {
        this.user_active = user_active;
    }
    
    
    
}
