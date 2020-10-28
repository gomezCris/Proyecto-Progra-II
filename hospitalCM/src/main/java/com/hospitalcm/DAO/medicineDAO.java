/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.DAO;
import com.hospitalcm.conexion.Conexion;
import com.hospitalcm.model.MedicineModel;
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


public class medicineDAO {
    //Conexión
    Connection connection;
    Conexion con = new Conexion();
    
    ResultSet rs;
    int resultado;
 
    //Declaración de variables de objeto
    int medicine_id;
    int tp_id;
    double medicine_costPrice;
    double medicine_costSale;
    int medicine_existence;
    
    //Declaración de Consultas
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Medicine";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Medicine WHERE medicine_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Medicine WHERE medicine_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Medicine SET tp_id = (?), medicine_costPrice = (?), medicine_costSale = (?), medicine_existence = (?) WHERE medicine_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Medicine  VALUES (NULL, ?, ?, ?, ?)";
    
    //MÉTODOS CRUD
    //AGREGAR
    public boolean agregarDAO(MedicineModel objUse){
        boolean res;
        
        try{
            String sql = INSERT;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMedicine_id());
            statement.setInt(1, objUse.getTp_id());
            statement.setDouble(2, objUse.getMedicine_costPrice());
            statement.setDouble(3, objUse.getMedicine_costSale());
            statement.setInt(4, objUse.getMedicine_existence());
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
    public  List<MedicineModel> obtenerTodosDAO(){
        boolean res;
        List<MedicineModel> listaTodos = new ArrayList<MedicineModel>();
        
        try{
            String sql = selectALL;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    medicine_id = rs.getInt("medicine_id");
                    tp_id = rs.getInt("tp_id");
                    medicine_costPrice = rs.getDouble("medicine_costPrice");
                    medicine_costSale = rs.getDouble("medicine_costSale");
                    medicine_existence = rs.getInt("medicine_existence");
                    MedicineModel objUse = new MedicineModel(medicine_id, tp_id, medicine_costPrice, medicine_costSale, medicine_existence);
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
     public  MedicineModel obtenerDAO(int idBuscar){
        boolean res;
        MedicineModel objUse;
        
        try{
            String sql = selectByID + Integer.toString(idBuscar);
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            rs = statement.executeQuery(sql);
            
            res = true;
            
            if(res){
                while(rs.next()){
                    medicine_id = rs.getInt("medicine_id");
                    tp_id = rs.getInt("tp_id");
                    medicine_costPrice = rs.getDouble("medicine_costPrice");
                    medicine_costSale = rs.getDouble("medicine_costSale");
                    medicine_existence = rs.getInt("medicine_existence");
                }
            }
            connection.close();
        }catch(SQLException e){
            e.getMessage();
           return null;
        }
        objUse = new MedicineModel(medicine_id, tp_id, medicine_costPrice, medicine_costSale, medicine_existence);
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
     public boolean actualizarDAO(MedicineModel objUse){
        boolean res;
        
        try{
            String sql = UPDATE;
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setInt(1, objUse.getMedicine_id());
            statement.setInt(1, objUse.getTp_id());
            statement.setDouble(2, objUse.getMedicine_costPrice());
            statement.setDouble(3, objUse.getMedicine_costSale());
            statement.setInt(4, objUse.getMedicine_existence());
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
