
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.rolesModel;
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

public class rolesDAO {
    
    //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    boolean res;
    
    //Declaración de variables de objeto
    int rolId;
    String rolName;
    String rolDescription;
    boolean rolActive;
    Date role_register;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Roles";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Roles where role_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Roles where role_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Roles SET role_name = (?), role_description = (?), role_active = (?), role_register = (?) where role_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Roles VALUES (NULL, ?, ?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROLl
   public boolean addRole(rolesModel objRol){
       
       try{
           //ASignamos la consulta a la variable sql
           String sql = INSERT;
           //Obtenemos la conexión a la DB
           connection = con.getConnection();
           //Preparamos la consulta
           PreparedStatement statement = connection.prepareStatement(sql);
           
           //ASignamos los valores a la consulta INSERT
           statement.setString(1, objRol.getRolName());
           statement.setString(2, objRol.getRolDescription());
           statement.setBoolean(3, objRol.isRolActive());
           statement.setDate(4, objRol.getRole_register());
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
   public List<rolesModel> getRoles(){
       //Creación de la lista que se devolverá como respuesta
       List<rolesModel> listaRoles = new ArrayList<rolesModel>();
       
        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectALL);
            statement.execute();
            rs = statement.executeQuery();

            res = true;
            if(res){
                while(rs.next()){
                    rolId = rs.getInt("role_id");
                    rolName = rs.getString("role_name");
                    rolDescription = rs.getString("role_description");
                    rolActive = rs.getBoolean("role_active");
                    role_register = rs.getDate("role_register");

                    rolesModel objRole = new rolesModel(rolId, rolName, rolDescription, rolActive, role_register);

                    listaRoles.add(objRole);
                }
            }

            connection.close();
            return listaRoles;
        }catch(SQLException e){
            return listaRoles;
        }
   }
   
    //OBTENER UN REGISTRO
    public rolesModel getRole(int idBuscar){
        rolesModel objRole;
        try{
             connection = con.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
             statement.execute();
             rs = statement.executeQuery();

             res = true;
             if(res){
                 while(rs.next()){
                     rolId = rs.getInt("role_id");
                     rolName = rs.getString("role_name");
                     rolDescription = rs.getString("role_description");
                     rolActive = rs.getBoolean("role_active");
                     role_register = rs.getDate("role_register");

                 }
             }

             connection.close();
             objRole = new rolesModel(rolId, rolName, rolDescription, rolActive, role_register);
             return objRole;
         }catch(SQLException e){
             return null;
         }
    }
   
   //ELIMINAR UN REGISTRO
    public boolean deleteRole(int idBuscar){
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
    public boolean updateRole(rolesModel objRol){
        try{
            String sql = UPDATE + objRol.getRole_id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setString(1, objRol.getRolName());
            statement.setString(2, objRol.getRolDescription());
            statement.setBoolean(3, objRol.isRolActive());
            statement.setDate(4, objRol.getRole_register());
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
