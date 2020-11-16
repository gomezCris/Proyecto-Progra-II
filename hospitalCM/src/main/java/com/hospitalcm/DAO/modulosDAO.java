
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.ModulosModel;
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

public class modulosDAO {
   
     //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;  
    boolean res;
    
    
    //Declaración de variables de objeto
   int Modulo_ID; 
   String Module_name;
   String Module_description;
   boolean active;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Modules WHERE active = true";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Modules where module_id = ";
    String deleteByID = "UPDATE From gearsgtc_java_hospital.hl_Modules SET active = false where  module_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Modules SET module_name = (?), module_description = (?) where module_id =";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Modules VALUES (NULL, ?, ?)";
    
    //Creación de métodos
    //AGREGAR
   public boolean addModule(ModulosModel objModule){
       
       try{
           //ASignamos la consulta a la variable sql
           String sql = INSERT;
           //Obtenemos la conexión a la DB
           connection = con.getConnection();
           //Preparamos la consulta
           PreparedStatement statement = connection.prepareStatement(sql);
           
           //ASignamos los valores a la consulta INSERT
           
           statement.setString(1, objModule.getModule_name());
           statement.setString(2, objModule.getModule_description());
         
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
    
   //OBTENER TODOS LOS REGISTROS
    public List<ModulosModel> getModulos(){
       //Creación de la lista que se devolverá como respuesta
       List<ModulosModel> listaModulos = new ArrayList<ModulosModel>();
       
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectALL);
           statement.execute();
           rs = statement.executeQuery();
           
           res = true;
           if(res){
               while(rs.next()){
                   Modulo_ID = rs.getInt("module_id");
                   Module_name = rs.getString("module_name");
                   Module_description = rs.getString("module_description");
                   active = rs.getBoolean("active");
                   
                   ModulosModel objModule = new ModulosModel(Modulo_ID, Module_name, Module_description, active);
                   
                   listaModulos.add(objModule);
               }
           }
           
           connection.close();
           return listaModulos;
       }catch(SQLException e){
           return listaModulos;
       }
   }
   
    //OBTENER UN REGISTRO
    public ModulosModel getModule(int idBuscar){
       ModulosModel objModule;
        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
            rs = statement.executeQuery();
            res = true;
            if(res){
                while(rs.next()){
                    Modulo_ID = rs.getInt("module_id");
                    Module_name = rs.getString("module_name");
                    Module_description = rs.getString("module_description");
                    active = rs.getBoolean("active");
                }
            }
            connection.close();
            objModule = new ModulosModel(Modulo_ID, Module_name, Module_description, active);
            return objModule;
        }catch(SQLException e){
            e.getMessage();
            return null;
        }
    }
   
    //ELIMINAR UN REGISTRO
    public boolean deleteModule(int idBuscar){
        try{
             String sql =  deleteByID + Integer.toString(idBuscar);
             connection = con.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);

             statement.execute();
             connection.close();
             res = true;
             return res;
         }catch(SQLException e){
             e.getMessage();
             res = false;
            return res;
         }
    }
   
    //ACTUALIZAR UN REGISTRO
    public boolean updateModule(ModulosModel objModule){
        try{
            String sql = UPDATE + objModule.getModule_id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, objModule.getModule_name());
            statement.setString(2, objModule.getModule_description());
            statement.execute();
            connection.close();
            res = true;
            return res;
        }catch(SQLException e){
            e.getMessage();
            res = false;
           return res;
        }
    }
    
    
}
