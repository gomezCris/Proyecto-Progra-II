
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.Patients_Model;
//Librerías de conexión a DB
import java.sql.Connection;
import java.sql.Date;
//Para ejecutar consultas a DB
import java.sql.PreparedStatement;
//Para guardar el resultado de la consulta
import java.sql.ResultSet;
//Manejo de excepciones
import java.sql.SQLException;
//Uso de arrayList
import java.util.ArrayList;
//Uso de listas
import java.util.List;

public class patientsDAO {
    
     //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    
    //Declaración de variables de objeto
   Date Patient_startdate; 
   String Patient_username; 
   String Patient_password; 
   Date Patient_stopdate; 
   boolean Patient_active; 
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Patients";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Patients where patient_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Patients where patient_id = ";
    String updateByID = "";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Patients VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
   public boolean addPatient(Patients_Model objPatient){
       //Variable de resultado que se retornará
       boolean res;
       
       try{
           //ASignamos la consulta a la variable sql
           String sql = INSERT;
           //Obtenemos la conexión a la DB
           connection = con.getConnection();
           //Preparamos la consulta
           PreparedStatement statement = connection.prepareStatement(sql);
           
           //ASignamos los valores a la consulta INSERT
           statement.setDate(1, objPatient.getPatient_startdate());
           statement.setString(2, objPatient.getPatient_username());
           statement.setString(3, objPatient.getPatient_password());
           statement.setDate(4, objPatient.getPatient_stopdate());
           statement.setBoolean(5, objPatient.isPatient_active());
           statement.setInt(6, objPatient.getUser_id());
           statement.setDate(7, objPatient.getPatient_register());
           
           //Ejecutamos la consulta
           statement.execute();
           //Cerramos la conexión
           connection.close();
           //ASignamos la respuesta como true
           res = true;
           return res;
       }catch(SQLException e){
           e.getMessage();
           res = false;
           return res;
       }
   }
    
   
   public void getPatients(){
       
   }
   
   public void getPatient(){
       
   }
   
   public void deletePatient(){
       
   }
   
   public void updatePatient(){
       
   }
    
   
}
