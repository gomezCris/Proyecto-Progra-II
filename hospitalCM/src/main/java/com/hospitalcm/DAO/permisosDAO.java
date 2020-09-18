
package com.hospitalcm.DAO;
// Importacion de clase
import com.hospitalcm.DAO.permisosDAO;
//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.PermisosModel;
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


public class permisosDAO {
    
    //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    
    //Declaración de variables de objeto
    boolean Permission_create;
    boolean Permission_read;
    boolean Permission_update;
    boolean Permission_delete;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from hl_Permissions";
    String selectByID = "Select * from hl_Permissions where module_id = ";
    String deleteByID = "Delete * From hl_Permissions where module_id = ";
    String updateByID = "";
    String INSERT = "Insert into hl_Permissions VALUES (?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
   public boolean addPermission(PermisosModel objPermission){
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
           statement.setBoolean(1, objPermission.isPermission_create());
           statement.setBoolean(2, objPermission.isPermission_read());
           statement.setBoolean(3, objPermission.isPermission_update());
           statement.setBoolean(4, objPermission.isPermission_delete());
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
    
   
   public void getPermissions(){
       
   }
   
   public void getPermission(){
       
   }
   
   public void deletePermission(){
       
   }
   
   public void updatePermission(){
       
   }
   
 
}
