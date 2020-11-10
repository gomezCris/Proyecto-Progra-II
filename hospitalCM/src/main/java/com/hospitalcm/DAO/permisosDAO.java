
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
    int Permission_Id;
    int rolId; 
    int ModuleId; 
    boolean Permission_create;
    boolean Permission_read;
    boolean Permission_update;
    boolean Permission_delete;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Permissions";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Permissions where permission_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Permissions where permission_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Permissions SET role_id = (?), module_id = (?), permission_create = (?), permission_read = (?), permission_update = (?), permission_delete = (?)  where permission_id =";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Permissions VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
    public boolean addPermission(PermisosModel objPermission){

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
    
   //OBTENER TODOS LOS REGISTROS
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
                    Permission_Id = rs.getInt("permission_id");
                    rolId = rs.getInt("role_id");
                    ModuleId = rs.getInt("module_id");
                    Permission_create = rs.getBoolean("permission_create");
                    Permission_read = rs.getBoolean("permission_read");
                    Permission_update = rs.getBoolean("permission_update");
                    Permission_delete = rs.getBoolean("permission_delete");

                    PermisosModel objPermissions = new PermisosModel(Permission_Id,rolId, ModuleId, Permission_create, Permission_read, Permission_update, Permission_delete);

                    listaPermisos.add(objPermissions);
                }
            }

            connection.close();
            return listaPermisos;
        }catch(SQLException e){
            return listaPermisos;
        }
    }
   
    //OBTENER UN REGISTRO
    public PermisosModel getPermission(int idBuscar){
        PermisosModel objPermissions;
        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
            statement.execute();
            rs = statement.executeQuery();

            res = true;
            if(res){
                while(rs.next()){
                    Permission_Id = rs.getInt("permission_id");
                    rolId = rs.getInt("role_id");
                    ModuleId = rs.getInt("module_id");
                    Permission_create = rs.getBoolean("permission_create");
                    Permission_read = rs.getBoolean("permission_read");
                    Permission_update = rs.getBoolean("permission_update");
                    Permission_delete = rs.getBoolean("permission_delete");
                }
            }

            connection.close();
            objPermissions = new PermisosModel(Permission_Id,rolId, ModuleId, Permission_create, Permission_read, Permission_update, Permission_delete);
            return objPermissions;
        }catch(SQLException e){
            return null;
        }
    }

    //ELIMINAR UN REGISTRO
    public boolean deletePermission(int idBuscar){
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
    public boolean updatePermission(PermisosModel objPermission){
        try{
            String sql = UPDATE + objPermission.getPermission_Id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, objPermission.getRole_id());
            statement.setInt(2, objPermission.getModule_id());
            statement.setBoolean(3, objPermission.isPermission_create());
            statement.setBoolean(4, objPermission.isPermission_read());
            statement.setBoolean(5, objPermission.isPermission_update());
            statement.setBoolean(6, objPermission.isPermission_delete());
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
