/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;

import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.TypePresentationModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Denzil Barrios
 * GoDevs Team-2,020
 */


public class TypePresentationDAO {
      //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    //Declaración de variables de objeto
    int tp_id;
    String tp_name;
    String tp_description;
    boolean active;
    
    //Declaración de Consultas
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_TypePresentation WHERE active = true";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_TypePresentation WHERE tp_id = ";
    String deleteByID = "UPDATE From gearsgtc_java_hospital.hl_TypePresentation SET active = false WHERE tp_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_TypePresentation SET tp_name = (?), tp_description = (?) WHERE tp_id = (?)";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_TypePresentation  VALUES (NULL, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarDAO(TypePresentationModel objUse){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMdDetails_id());
            statement.setString(1, objUse.getTp_name());
            statement.setString(2, objUse.getTp_description());
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
    
    //OBTENER TODOS LOS REGISTROS
    public  List<TypePresentationModel> obtenerTodosDAO(){
        boolean res;
        List<TypePresentationModel> listaTodos = new ArrayList<TypePresentationModel>();
        
        try{
            String sql = selectALL;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    tp_id = rs.getInt("tp_id");
                    tp_name = rs.getString("tp_name");
                    tp_description = rs.getString("tp_description");
                    active = rs.getBoolean("active");
                    TypePresentationModel objUse = new TypePresentationModel(tp_id, tp_name, tp_description, active);
                    listaTodos.add(objUse);
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return listaTodos;
        }
        
        return listaTodos;
    }
    
    //OBTENER UNA REGISTRO
     public  TypePresentationModel obtenerDAO(int idBuscar){
        boolean res;
        TypePresentationModel objUse;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    tp_id = rs.getInt("tp_id");
                    tp_name = rs.getString("tp_name");
                    tp_description = rs.getString("tp_description");
                    active = rs.getBoolean("active");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUse = new TypePresentationModel(tp_id, tp_name, tp_description, active);
        return objUse;
    }
     
     //ELIMINAR
     public boolean eliminarDAO(int idBuscar){
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
     public boolean actualizarDAO(TypePresentationModel objUse){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMdDetails_id());
            statement.setString(1, objUse.getTp_name());
            statement.setString(2, objUse.getTp_description());
            statement.setInt(3, objUse.getTp_id());
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
