/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;

import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.pruebaApiUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Coronado
 */
public class pruebaApiUsuarioDAO {
    //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarPruebaApiUsuario(pruebaApiUsuario objPrueba){
        boolean res;
        
        try{
            String sql = "INSERT INTO pruebaApiUsuario VALUES(?, ?, ?, ?, ?)";
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, objPrueba.getId());
            statement.setString(2, objPrueba.getNombre());
            statement.setString(3, objPrueba.getApellido());
            statement.setInt(4, objPrueba.getEdad());
            statement.setString(5, objPrueba.getTel());
            statement.execute();
            //rs = statement.executeQuery(sql);
            connection.close();
            res = true;
            
        }catch(SQLException e){
            e.printStackTrace();
            e.getMessage();
            res = false;
           return res;
        }
        
        return res;
    }
    /*
    //EDITAR
    public boolean editarPruebaApiUsuario(pruebaApiUsuario objPrueba){
        
        return true;
    }
    
    //ELIMINAR
    public boolean eliminarPruebaApiUsuario(int id){
        
        return true;
    }
    
    
    
    //OBTENER UN USUARIO
    public pruebaApiUsuario obtenerPruebaApiUsuario(int id){
        
        return null;
    }
    */
    
    //OBTENER TODOS LOS USUARIOS
    public  List<pruebaApiUsuario> obtenerPruebaApiUsuarios(){
        boolean res;
        List<pruebaApiUsuario> listaUsuarios = new ArrayList<pruebaApiUsuario>();
        String registro;
        
        
        try{
            String sql = "SELECT * FROM gearsgtc_hospital_java.pruebaApiUsuario";
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");
                    String tel = rs.getString("tel");
                    pruebaApiUsuario objUsuario = new pruebaApiUsuario(id, nombre, apellido, edad, tel);
                    listaUsuarios.add(objUsuario);
                }
            }
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
            e.getMessage();
            res = false;
           return listaUsuarios;
        }
        
        return listaUsuarios;
    }
    
    //OBTENER UN USUARIO
     public  List<pruebaApiUsuario> obtenerPruebaApiUsuario(int idBuscar){
        boolean res;
        List<pruebaApiUsuario> listaUsuario = new ArrayList<pruebaApiUsuario>();
        
        
        try{
            String sql = "SELECT * FROM gearsgtc_hospital_java.pruebaApiUsuario where id = " + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");
                    String tel = rs.getString("tel");
                    pruebaApiUsuario objUsuario = new pruebaApiUsuario(id, nombre, apellido, edad, tel);
                    listaUsuario.add(objUsuario);
                }
            }
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
            e.getMessage();
            res = false;
           return listaUsuario;
        }
        
        return listaUsuario;
    }
}
