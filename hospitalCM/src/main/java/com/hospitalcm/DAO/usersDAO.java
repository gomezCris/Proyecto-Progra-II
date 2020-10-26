
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
    boolean res;
    //Declaración de variables de objeto
    int user_id; 
    Date user_register; 
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
    
   
    public List<Users_Model> getUsers(){
       //Creación de la lista que se devolverá como respuesta
       List<Users_Model> listaUsers = new ArrayList<Users_Model>();
       
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectALL);
           statement.execute();
           rs = statement.executeQuery();
           
           res = true;
           if(res){
               while(rs.next()){
                   user_id = rs.getInt("user_id");
                   User_firstname = rs.getString("user_firstname");
                   User_lastname = rs.getString("user_lastname");
                   User_email = rs.getString("User_email");
                   User_phonenumber = rs.getString("user_phonenumber");
                   User_birthdate = rs.getDate("user_birthdate");
                   User_address = rs.getString("user_address");
                   User_active = rs.getBoolean("user_active");
                   user_register = rs.getDate("user_register");
                 
                   Users_Model objUse = new Users_Model(user_id, User_firstname,  User_lastname,  User_email, User_phonenumber, User_birthdate,User_address,User_active,user_register);
                   
                   listaUsers.add(objUse);
               }
           }
           
           connection.close();
           return listaUsers;
       }catch(SQLException e){
           return listaUsers;
       }
   }
   
   public void getUse(){
       
   }
   
   public void deleteUse(){
       
   }
   
   public void updateUse(){
       
   }
   
}
