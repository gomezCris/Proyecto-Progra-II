/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;

import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.mdDetailsModel;
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


public class mdDetailsDAO {
    //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    //Declaración de variables de objeto
    int mdDetails_id;
    int md_id;
    String mdDetails_systomp;
    int medicine_id;
    String mdDetails_dose;
    
    //Declaración de Consultas
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_mdDetails";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_mdDetails WHERE mdDetails_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_mdDetails WHERE mdDetails_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_mdDetails SET md_id = (?), mdDetails_systomp = (?), medicine_id = (?), mdDetails_dose = (?) WHERE mdDetails_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_mdDetails  VALUES (NULL, ?, ?, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarDAO(mdDetailsModel objUse){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMdDetails_id());
            statement.setInt(1, objUse.getMd_id());
            statement.setString(2, objUse.getMdDetails_systomp());
            statement.setInt(3, objUse.getMedicine_id());
            statement.setString(4, objUse.getMdDetails_dose());
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
    
    //OBTENER TODOS LAS CONSULTAS MEDICAS
    public  List<mdDetailsModel> obtenerTodosDAO(){
        boolean res;
        List<mdDetailsModel> listaTodos = new ArrayList<mdDetailsModel>();
        
        try{
            String sql = selectALL;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    mdDetails_id = rs.getInt("mdDetails_id");
                    md_id = rs.getInt("md_id");
                    mdDetails_systomp = rs.getString("mdDetails_systomp");
                    medicine_id = rs.getInt("medicine_id");
                    mdDetails_dose = rs.getString("mdDetails_dose");
                    mdDetailsModel objUse = new mdDetailsModel(mdDetails_id, md_id, mdDetails_systomp, medicine_id, mdDetails_dose);
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
    
    //OBTENER UNA CONSULTA MEDICA
     public  mdDetailsModel obtenerDAO(int idBuscar){
        boolean res;
        mdDetailsModel objUse;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    mdDetails_id = rs.getInt("mdDetails_id");
                    md_id = rs.getInt("md_id");
                    mdDetails_systomp = rs.getString("mdDetails_systomp");
                    medicine_id = rs.getInt("medicine_id");
                    mdDetails_dose = rs.getString("mdDetails_dose");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUse = new mdDetailsModel(mdDetails_id, md_id, mdDetails_systomp, medicine_id, mdDetails_dose);
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
     public boolean actualizarDAO(mdDetailsModel objUse){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMdDetails_id());
            statement.setInt(1, objUse.getMd_id());
            statement.setString(2, objUse.getMdDetails_systomp());
            statement.setInt(3, objUse.getMedicine_id());
            statement.setString(4, objUse.getMdDetails_dose());
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
