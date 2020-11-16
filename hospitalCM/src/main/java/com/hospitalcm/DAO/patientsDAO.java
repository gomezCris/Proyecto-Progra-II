
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.Patients_Model;
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

public class patientsDAO {
    
     //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    boolean res;
    //Declaración de variables de objeto
   int patient_id; 
   Date Patient_startdate; 
   String Patient_username; 
   String Patient_password; 
   Date Patient_stopdate; 
   boolean Patient_active; 
   int user_id;
   Date patient_register;
   boolean active;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Patients where active = true";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Patients where patient_id = ";
    String deleteByID = "UPDATE From gearsgtc_java_hospital.hl_Patients SET active = false where patient_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Patients SET patient_startdate = (?), patient_username = (?), patient_password = (?), patient_stopdate = (?), patient_active = (?), user_id = (?), patient_register = (?) where patient_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Patients VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
    public boolean addPatient(Patients_Model objPatient){
       
        try{
            //ASignamos la consulta a la variable sql
            String sql = INSERT;
            //Obtenemos la conexión a la DB
            connection = con.getConnection();
            //Preparamos la consulta
            PreparedStatement statement = connection.prepareStatement(sql);

            //ASignamos los valores a la consulta INSERT
            statement.setDate(1, objPatient.getPatient_startdate());
            statement.setString(2, objPatient.getPatient_username());
            statement.setString(3, objPatient.getPatient_password());
            statement.setDate(4, objPatient.getPatient_stopdate());
            statement.setBoolean(5, objPatient.isPatient_active());
            statement.setInt(6, objPatient.getUser_id());
            statement.setDate(7, objPatient.getPatient_register());

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
    public List<Patients_Model> getPatients(){
        //Creación de la lista que se devolverá como respuesta
        List<Patients_Model> listaPatients = new ArrayList<Patients_Model>();

        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectALL);
            statement.execute();
            rs = statement.executeQuery();

            res = true;
            if(res){
                while(rs.next()){
                    patient_id = rs.getInt("patient_id");
                    Patient_startdate = rs.getDate("patient_startdate");
                    Patient_username = rs.getString("patient_username");
                    Patient_password = rs.getString("patient_password");
                    Patient_stopdate = rs.getDate("patient_stopdate");
                    Patient_active = rs.getBoolean("patient_active");
                    user_id = rs.getInt("user_id");
                    patient_register = rs.getDate("patient_register");
                    active = rs.getBoolean("active");

                    Patients_Model objPatients = new Patients_Model( patient_id,  Patient_startdate, Patient_username,  Patient_password ,  Patient_stopdate,Patient_active, user_id, patient_register, active);

                    listaPatients.add(objPatients);
                }
            }

            connection.close();
            return listaPatients;
        }catch(SQLException e){
            return listaPatients;
        }
    }
   
    //OBTENER UN REGISTRO
    public Patients_Model getPatient(int idBuscar){
        Patients_Model objPatients;
        try{
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
            statement.execute();
            rs = statement.executeQuery();

            res = true;
            if(res){
                while(rs.next()){
                    patient_id = rs.getInt("patient_id");
                    Patient_startdate = rs.getDate("patient_startdate");
                    Patient_username = rs.getString("patient_username");
                    Patient_password = rs.getString("patient_password");
                    Patient_stopdate = rs.getDate("patient_stopdate");
                    Patient_active = rs.getBoolean("patient_active");
                    user_id = rs.getInt("user_id");
                    patient_register = rs.getDate("patient_register");
                    active = rs.getBoolean("active");
                }
            }

            connection.close();
            objPatients = new Patients_Model( patient_id,  Patient_startdate, Patient_username,  Patient_password ,  Patient_stopdate,Patient_active, user_id, patient_register, active);
            return objPatients;
        }catch(SQLException e){
            e.getMessage();
            return null;
        }
    }
   
    //ELIMINAR UN REGISTRO
    public boolean deletePatient(int idBuscar){
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
    public boolean updatePatient(Patients_Model objPatient){
        try{
            String sql = UPDATE + objPatient.getPatient_id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setDate(1, objPatient.getPatient_startdate());
            statement.setString(2, objPatient.getPatient_username());
            statement.setString(3, objPatient.getPatient_password());
            statement.setDate(4, objPatient.getPatient_stopdate());
            statement.setBoolean(5, objPatient.isPatient_active());
            statement.setInt(6, objPatient.getUser_id());
            statement.setDate(7, objPatient.getPatient_register());
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
