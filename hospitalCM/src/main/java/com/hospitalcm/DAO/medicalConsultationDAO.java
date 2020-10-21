/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;

import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.medicalConsultationModel;
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

public class medicalConsultationDAO {
    //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    //Declaración de variables de objeto
    int id;
    int secretary_id;
    int doctor_id;
    int patient_id;
    Date appointment;
    boolean confirmation;
    
    //Declaración de Consultas
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_MedicalConsultation";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_MedicalConsultation WHERE mc_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_MedicalConsultation WHERE mc_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_MedicalConsultation SET mc_secretary_id = (?), mc_doctor_id = (?), patient_id = (?), mc_appointment = (?), mc_confirmation = (?) WHERE mc_id = ";
    String INSERT = "Insert into hl_Users  VALUES (NULL, ?, ?, ?, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarMedicalConsultation(medicalConsultationModel objUse){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, objUse.getMc_secretary_id());
            statement.setInt(2, objUse.getMc_doctor_id());
            statement.setInt(3, objUse.getPatient_id());
            statement.setDate(4, objUse.getMc_appointment());
            statement.setBoolean(5, objUse.isMc_confirmation());
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
    public  List<medicalConsultationModel> obtenerMedicalConsultations(){
        boolean res;
        List<medicalConsultationModel> listaMedicalConsultation = new ArrayList<medicalConsultationModel>();
        
        try{
            String sql = selectALL;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    id = rs.getInt("mc_id");
                    secretary_id = rs.getInt("mc_secretary_id");
                    doctor_id = rs.getInt("mc_doctor_id");
                    patient_id = rs.getInt("patient_id");
                    appointment = rs.getDate("mc_appointment");
                    confirmation = rs.getBoolean("mc_confirmation");
                    medicalConsultationModel objUse = new medicalConsultationModel(id, secretary_id, doctor_id, patient_id, appointment, confirmation);
                    listaMedicalConsultation.add(objUse);
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return listaMedicalConsultation;
        }
        
        return listaMedicalConsultation;
    }
    
    //OBTENER UN USUARIO
     public  medicalConsultationModel obtenerMedicalConsultation(int idBuscar){
        boolean res;
        medicalConsultationModel objUse;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    id = rs.getInt("mc_id");
                    secretary_id = rs.getInt("mc_secretary_id");
                    doctor_id = rs.getInt("mc_doctor_id");
                    patient_id = rs.getInt("patient_id");
                    appointment = rs.getDate("mc_appointment");
                    confirmation = rs.getBoolean("mc_confirmation");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUse = new medicalConsultationModel(id, secretary_id, doctor_id, patient_id, appointment, confirmation);
        return objUse;
    }
     
     //ELIMINAR
     public boolean eliminarMedicalCosultation(int idBuscar){
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
     public boolean actualizarMedicalConsultation(medicalConsultationModel objUse){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, objUse.getMc_secretary_id());
            statement.setInt(2, objUse.getMc_doctor_id());
            statement.setInt(3, objUse.getPatient_id());
            statement.setDate(4, objUse.getMc_appointment());
            statement.setBoolean(5, objUse.isMc_confirmation());
            statement.setInt(6, objUse.getMc_id());
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