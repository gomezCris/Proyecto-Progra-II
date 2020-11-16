
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
    boolean active;
    
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Specialitys WHERE active = true";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Specialitys where speciality_id = ";
    String deleteByID = "UPDATE From gearsgtc_java_hospital.hl_Specialitys SET active = false where speciality_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Specialitys SET speciality_name = (?), speciality_description = (?) where speciality_id =";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Specialitys VALUES (NULL, ?, ?)";
    
    //Creación de métodos
    //AGREGAR
    public boolean addSpeciality(EspecialistasModel objSpeciality){
       
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
     
    //OBTENER TODOS LOS REGISTROS
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
                   active = rs.getBoolean("active");
                   
                   
                   EspecialistasModel objSpeciality = new EspecialistasModel(Speciality_id, Speciality_name ,speciality_description, active);
                   
                   listaEspecialistas.add(objSpeciality);
               }
           }
           
           connection.close();
           return listaEspecialistas;
        }catch(SQLException e){
           return listaEspecialistas;
        }
    }
    //OBTENER UN REGISTRO
    public EspecialistasModel getSpeciality(int idBuscar){
        EspecialistasModel objEspecialidad;
        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
            rs = statement.executeQuery();
            res = true;
            if(res){
                while(rs.next()){
                   Speciality_id = rs.getInt("speciality_id"); 
                   Speciality_name = rs.getString("speciality_name");
                   speciality_description = rs.getString("speciality_description");
                   active = rs.getBoolean("active");
                }
            }
            connection.close();
            objEspecialidad = new EspecialistasModel(Speciality_id, Speciality_name ,speciality_description, active);
            return objEspecialidad;
        }catch(SQLException e){
           e.getMessage();
           return null;
        }
    }
   
    //ELIMINAR UN REGISTRO
    public boolean deleteSpeciality(int idBuscar){
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
   public boolean updateSpeciality(EspecialistasModel objEspecialidad){
       try{
            String sql = UPDATE + objEspecialidad.getSpeciality_id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, objEspecialidad.getSpeciality_name());
            statement.setString(2, objEspecialidad.getSpeciality_description());
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
