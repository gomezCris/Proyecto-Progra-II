
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
     boolean res;
    //Declaración de variables de objeto
    int rolId; 
    int ModuleId; 
    boolean Permission_create;
    boolean Permission_read;
    boolean Permission_update;
    boolean Permission_delete;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Permissions";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Permissions where role_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Permissions where role_id = ";
    String updateByID = "";
    String INSERT = "Insert into earsgtc_java_hospital.hl_Permissions VALUES (?, ?, ?, ?, ?, ?)";
    
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
           statement.setInt(1, objPermission.getRole_id());
           statement.setInt(2, objPermission.getModule_id());
           statement.setBoolean(3, objPermission.isPermission_create());
           statement.setBoolean(4, objPermission.isPermission_read());
           statement.setBoolean(5, objPermission.isPermission_update());
           statement.setBoolean(6, objPermission.isPermission_delete());
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
    
   
   public List<PermisosModel> getPermissions(){
       //Creación de la lista que se devolverá como respuesta
       List<PermisosModel> listaPermisos = new ArrayList<PermisosModel>();
       
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectALL);
           statement.execute();
           rs = statement.executeQuery();
           
           res = true;
           if(res){
               while(rs.next()){
                   rolId = rs.getInt("role_id");
                   ModuleId = rs.getInt("module_id");
                   Permission_create = rs.getBoolean("permission_create");
                   Permission_read = rs.getBoolean("permission_read");
                   Permission_update = rs.getBoolean("permission_update");
                   Permission_delete = rs.getBoolean("permission_delete");
                   
                   PermisosModel objPermissions = new PermisosModel(rolId, ModuleId, Permission_create, Permission_read, Permission_update, Permission_delete);
                   
                   listaPermisos.add(objPermissions);
               }
           }
           
           connection.close();
           return listaPermisos;
       }catch(SQLException e){
           return listaPermisos;
       }
   }
   
   public void getPermission(){
       
   }
   
   public void deletePermission(){
       
   }
   
   public void updatePermission(){
       
   }
   
 
}
