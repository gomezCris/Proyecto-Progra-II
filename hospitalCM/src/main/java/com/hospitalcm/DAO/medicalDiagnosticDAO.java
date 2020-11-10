/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;
import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.MedicalDiagnosticModel;
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


public class medicalDiagnosticDAO {
    //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    //Declaración de variables de objeto
    int md_id;
    int mc_id;
    String md_observations;
    Date md_beginTime;
    Date md_endTime;
    
    //Declaración de Consultas
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_MedicalDiagnostic";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_MedicalDiagnostic WHERE md_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_MedicalDiagnostic WHERE md_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_MedicalDiagnostic SET mc_id = (?), md_observations = (?), md_beginTime = (?), md_endTime = (?) WHERE md_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_MedicalDiagnostic  VALUES (NULL, ?, ?, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarDAO(MedicalDiagnosticModel objUse){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMd_id());
            statement.setInt(1, objUse.getMc_id());
            statement.setString(2, objUse.getMd_observations());
            statement.setDate(3, objUse.getMd_beginTime());
            statement.setDate(4, objUse.getMd_endTime());
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
    public  List<MedicalDiagnosticModel> obtenerTodosDAO(){
        boolean res;
        List<MedicalDiagnosticModel> listaTodos = new ArrayList<MedicalDiagnosticModel>();
        
        try{
            String sql = selectALL;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    md_id = rs.getInt("md_id");
                    mc_id = rs.getInt("mc_id");
                    md_observations = rs.getString("md_observations");
                    md_beginTime = rs.getDate("md_beginTime");
                    md_endTime = rs.getDate("md_endTime");
                    MedicalDiagnosticModel objUse = new MedicalDiagnosticModel(md_id, mc_id, md_observations, md_beginTime, md_endTime);
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
     public  MedicalDiagnosticModel obtenerDAO(int idBuscar){
        boolean res;
        MedicalDiagnosticModel objUse;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    md_id = rs.getInt("md_id");
                    mc_id = rs.getInt("mc_id");
                    md_observations = rs.getString("md_observations");
                    md_beginTime = rs.getDate("md_beginTime");
                    md_endTime = rs.getDate("md_endTime");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUse = new MedicalDiagnosticModel(md_id, mc_id, md_observations, md_beginTime, md_endTime);
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
     public boolean actualizarDAO(MedicalDiagnosticModel objUse){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMd_id());
            statement.setInt(1, objUse.getMc_id());
            statement.setString(2, objUse.getMd_observations());
            statement.setDate(3, objUse.getMd_beginTime());
            statement.setDate(4, objUse.getMd_endTime());
            statement.setInt(5, objUse.getMd_id());
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
