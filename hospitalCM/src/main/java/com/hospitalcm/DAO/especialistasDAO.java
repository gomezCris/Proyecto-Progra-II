
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.EspecialistasModel;
//Librerías de conexión a DB
import java.sql.Connection;
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

public class especialistasDAO {
      //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    
    //Declaración de variables de objeto

    String Speciality_name;
    String speciality_description;
    
    
    //Declaración de consultas a DB
    String selectALL = "Select * from hl_Specialitys";
    String selectByID = "Select * from hl_Specialitys where speciality_id; = ";
    String deleteByID = "Delete * From hl_Specialitys where speciality_id; = ";
    String updateByID = "";
    String INSERT = "Insert into hl_Specialitys VALUES (?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
   public boolean addSpeciality(EspecialistasModel objSpeciality){
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
           statement.setString(1, objSpeciality.getSpeciality_name());
           statement.setString(2, objSpeciality.getSpeciality_description());
        
           //Ejecutamos la consulta
           statement.execute();
           //Cerramos la conexión
           connection.close();
           //ASignamos la respuesta como true
           res = true;
   }catch(SQLException e){
           e.getMessage();
           res = false;
           return res;
       }
       
       return true;

}
      
   public void getEspecialistas(){
       
   }
   
   public void getSpeciality(){
       
   }
   
   public void deleteSpeciality(){
       
   }
   
   public void updateSpeciality(){
       
   }
}
