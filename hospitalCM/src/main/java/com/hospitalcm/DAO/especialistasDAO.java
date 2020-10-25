
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
    boolean res; 
    //Declaración de variables de objeto
    int Speciality_id; 
    String Speciality_name;
    String speciality_description;
    
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Specialitys";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Specialitys where speciality_id; = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Specialitys where speciality_id; = ";
    String updateByID = "";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Specialitys VALUES (NULL, ?, ?)";
    
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
           return res;
   }catch(SQLException e){
           e.getMessage();
           res = false;
           return res;
       }
}
      
   public List<EspecialistasModel> getEspecialistas(){
       //Creación de la lista que se devolverá como respuesta
       List<EspecialistasModel> listaEspecialistas = new ArrayList<EspecialistasModel>();
       
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectALL);
           statement.execute();
           rs = statement.executeQuery();
           
           res = true;
           if(res){
               while(rs.next()){
                   
                   Speciality_id = rs.getInt("speciality_id"); 
                   Speciality_name = rs.getString("speciality_name");
                   speciality_description = rs.getString("speciality_description");
                   
                   
                   EspecialistasModel objSpeciality = new EspecialistasModel(Speciality_id, Speciality_name ,speciality_description);
                   
                   listaEspecialistas.add(objSpeciality);
               }
           }
           
           connection.close();
           return listaEspecialistas;
       }catch(SQLException e){
           return listaEspecialistas;
       }
   }
   
   public void getSpeciality(){
       
   }
   
   public void deleteSpeciality(){
       
   }
   
   public void updateSpeciality(){
       
   }
}
