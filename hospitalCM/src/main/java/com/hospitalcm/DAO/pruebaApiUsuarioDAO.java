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
 
    //Declaración de variables de objeto
    int id;
    String nombre;
    String apellido;
    int edad;
    String tel;
    
    //Declaración de Consultas
    String selectAll = "SELECT * FROM gearsgtc_hospital_java.pruebaApiUsuario";
    String selectByID = "SELECT * FROM gearsgtc_hospital_java.pruebaApiUsuario where id = ";
    String deleteByID = "DELETE FROM gearsgtc_hospital_java.pruebaApiUsuario where id = ";
    String UPDATE = "UPDATE gearsgtc_hospital_java.pruebaApiUsuario SET id = (?), nombre = (?), apellido = (?), edad = (?), tel = (?) where id = ";
    String INSERT = "INSERT INTO pruebaApiUsuario VALUES(?, ?, ?, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarPruebaApiUsuario(pruebaApiUsuario objPrueba){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, objPrueba.getId());
            statement.setString(2, objPrueba.getNombre());
            statement.setString(3, objPrueba.getApellido());
            statement.setInt(4, objPrueba.getEdad());
            statement.setString(5, objPrueba.getTel());
            statement.execute();
            connection.close();
            res = true;
            
        }catch(SQLException e){
            e.getMessage();
            res = false;
           return res;
        }
        
        return res;
    }
    
    //OBTENER TODOS LOS USUARIOS
    public  List<pruebaApiUsuario> obtenerPruebaApiUsuarios(){
        boolean res;
        List<pruebaApiUsuario> listaUsuarios = new ArrayList<pruebaApiUsuario>();
        
        try{
            String sql = selectAll;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    edad = rs.getInt("edad");
                    tel = rs.getString("tel");
                    pruebaApiUsuario objUsuario = new pruebaApiUsuario(id, nombre, apellido, edad, tel);
                    listaUsuarios.add(objUsuario);
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return listaUsuarios;
        }
        
        return listaUsuarios;
    }
    
    //OBTENER UN USUARIO
     public  pruebaApiUsuario obtenerPruebaApiUsuario(int idBuscar){
        boolean res;
        pruebaApiUsuario objUsuario;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    apellido = rs.getString("apellido");
                    edad = rs.getInt("edad");
                    tel = rs.getString("tel");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUsuario = new pruebaApiUsuario(id, nombre, apellido, edad, tel);
        return objUsuario;
    }
     
     //ELIMINAR
     public boolean eliminarPruebaApiUsuario(int idBuscar){
        boolean res;
        
        try{
            String sql =  deleteByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.execute();
            connection.close();
            res = true;
            
        }catch(SQLException e){
            e.getMessage();
            res = false;
           return res;
        }
        
        return res;
    }
     
     
    //ACTUALIZAR
     public boolean ACTUALIZARPruebaApiUsuario(pruebaApiUsuario objPrueba){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, objPrueba.getId());
            statement.setString(2, objPrueba.getNombre());
            statement.setString(3, objPrueba.getApellido());
            statement.setInt(4, objPrueba.getEdad());
            statement.setString(5, objPrueba.getTel());
            statement.setInt(6, objPrueba.getId());
            statement.execute();
            connection.close();
            res = true;
            
        }catch(SQLException e){
            e.getMessage();
            res = false;
           return res;
        }
        
        return res;
    }
}
