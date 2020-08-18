package com.hospitalcm.model;

/**
 *
 * @author Cristian Coronado
 * GoDevs Team-2,020
 */
public class pruebaApiUsuario {
    int id;
    String nombre;
    String apellido;
    int edad;
    String tel;
    
    //Generación de constructor con campos
    public pruebaApiUsuario(int id, String nombre, String apellido, int edad, String tel) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tel = tel;
    }
    
    //Generación de constructor vacío
    public pruebaApiUsuario(){
    
    }
    
    /*
        Generación de Getters y Setters 
        para poder acceder a los campos desde fuera de la clase
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
