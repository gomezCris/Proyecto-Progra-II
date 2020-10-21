
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.EmployeesModel;
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


public class employeesDAO {
    
    //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    
    //Declaración de variables de objeto
     int Employees_id;
    Date Employees_startDate;
    float Employees_salary;
    String Employees_positionTitle;
    String Employees_username;
    String Employees_password;
    Date Employees_stopDate;
    boolean  Employees_active;
    int user_id;
    int speciality_id;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Employees";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Employees where employees_id = ";
    String deleteByID = "Delete From gearsgtc_java_hospital.hl_Employees where employees_id = ";
    String updateByID = "";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Employees VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         
    
    //Creación de métodos
    //ADD/AGREGAR, Recibe un objeto de tipo ROL
   public boolean addEmployee(EmployeesModel objEmployee){
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
           statement.setDate(1, objEmployee.getEmployees_startDate());
           statement.setFloat(2, objEmployee.getEmployees_salary());
           statement.setString(3, objEmployee.getEmployees_positionTitle());
           statement.setString(4, objEmployee.getEmployees_username());
           statement.setString(5, objEmployee.getEmployees_password());
           statement.setDate(6, objEmployee.getEmployees_stopDate());
           statement.setBoolean(7, objEmployee.isEmployees_active()); 
           statement.setInt(8, objEmployee.getUser_id());
           statement.setInt(9, objEmployee.getSpeciality_id());
           statement.setInt(10, objEmployee.getRole_id());
           statement.setDate(11, objEmployee.getEmployees_register());
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
    
   
   public void getemployees(){
       
   }
   
   public void getEmployee(){
       
   }
   
   public void deleteEmployee(){
       
   }
   
   public void updateEmployee(){
       
   }
}
