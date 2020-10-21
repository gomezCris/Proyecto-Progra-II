
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.Users_Model;
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

public class usersDAO {
    
      //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    
    //Declaración de variables de objeto
    String User_firstname; 
    String User_lastname; 
    String User_email; 
    String User_phonenumber; 
    Date User_birthdate; 
    String User_address; 
    boolean User_active; 
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Users";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Users where user_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Users where user_id = ";
    String updateByID = "";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Users  VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
   public boolean addUse(Users_Model objUse){
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
           statement.setString(1, objUse.getUser_firstname());
           statement.setString(2, objUse.getUser_lastname());
           statement.setString(3, objUse.getUser_email());
           statement.setString(4, objUse.getUser_phonenumber());
           statement.setDate(5, objUse.getUser_birthdate());
           statement.setString(6, objUse.getUser_address());
           statement.setBoolean(7, objUse.isUser_active());
           statement.setDate(8, objUse.getUser_register());
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
    
   
   public void getUsers(){
       
   }
   
   public void getUse(){
       
   }
   
   public void deleteUse(){
       
   }
   
   public void updateUse(){
       
   }
   
}
