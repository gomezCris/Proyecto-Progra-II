
package com.hospitalcm.DAO;

//importar el paquete de conexión a DB
import com.hospitalcm.conexion.Conexion;
//Importamos el model de Roles
import com.hospitalcm.model.EmployeesModel;
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


public class employeesDAO {
    
    //Obtener conexión a DB
    Connection connection;
    Conexion con = new Conexion();
    
    //Variables de resultado de consulta
    ResultSet rs;
    boolean res; 
    
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
    int role_id;
    Date employees_register;
    boolean active;
    
    //Declaración de consultas a DB
    String selectALL = "Select * from gearsgtc_java_hospital.hl_Employees WHERE active = true";
    String selectByID = "Select * from gearsgtc_java_hospital.hl_Employees where employees_id = ";
    String deleteByID = "UPDATE From gearsgtc_java_hospital.hl_Employees SET active = false where employees_id = ";
    String UPDATE = "UPDATE gearsgtc_java_hospital.hl_Employees SET employees_startdate = (?), employees_salary = (?),  employees_positionTitle = (?), employees_username = (?), employees_password = (?), employees_stopdate = (?), employees_active = (?), speciality_id = (?), role_id = (?), employees_register = (?), user_id = (?) where employees_id = ";
    String INSERT = "Insert into gearsgtc_java_hospital.hl_Employees VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
         
    
    //Métodos CRUD
    //AGREGAR
   public boolean addEmployee(EmployeesModel objEmployee){
       
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
           statement.setInt(8, objEmployee.getSpeciality_id());
           statement.setInt(9, objEmployee.getRole_id());
           statement.setDate(10, objEmployee.getEmployees_register());
           statement.setInt(11, objEmployee.getUser_id());
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
    public List<EmployeesModel> getEmployees(){
       //Creación de la lista que se devolverá como respuesta
       List<EmployeesModel> listaEmployees = new ArrayList<EmployeesModel>();
       
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectALL);
           statement.execute();
           rs = statement.executeQuery();
           
           res = true;
           if(res){
               while(rs.next()){
                   Employees_id = rs.getInt("employees_id");
                   Employees_startDate = rs.getDate("employees_startdate");
                   Employees_salary = rs.getFloat("employees_salary");
                   Employees_positionTitle = rs.getString("employees_positionTitle");
                   Employees_username = rs.getString("employees_username"); 
                   Employees_password = rs.getString("employees_password");
                   Employees_stopDate = rs.getDate("employees_stopdate");
                   Employees_active = rs.getBoolean("employees_active");
                   user_id = rs.getInt("user_id");
                   speciality_id = rs.getInt("speciality_id");
                   role_id = rs.getInt("role_id");
                   employees_register = rs.getDate("employees_register");
                   active = rs.getBoolean("active");
                   
                   EmployeesModel objEmployee = new EmployeesModel(Employees_id, Employees_startDate, Employees_salary, Employees_positionTitle, Employees_username, Employees_password, Employees_stopDate,Employees_active,user_id, speciality_id, role_id, employees_register, active);
                   
                   listaEmployees.add(objEmployee);
               }
           }
           
           connection.close();
           return listaEmployees;
       }catch(SQLException e){
           return listaEmployees;
       }
   }
   
    //OBTENER UN REGISTRO
   public EmployeesModel getEmployee(int idBuscar){
       EmployeesModel objEmployee;
       try{
           connection = con.getConnection();
           PreparedStatement statement = connection.prepareStatement(selectByID + idBuscar);
           rs = statement.executeQuery();
           res = true;
           if(res){
               while(rs.next()){
                   Employees_id = rs.getInt("employees_id");
                   Employees_startDate = rs.getDate("employees_startdate");
                   Employees_salary = rs.getFloat("employees_salary");
                   Employees_positionTitle = rs.getString("employees_positionTitle");
                   Employees_username = rs.getString("employees_username"); 
                   Employees_password = rs.getString("employees_password");
                   Employees_stopDate = rs.getDate("employees_stopdate");
                   Employees_active = rs.getBoolean("employees_active");
                   user_id = rs.getInt("user_id");
                   speciality_id = rs.getInt("speciality_id");
                   role_id = rs.getInt("role_id");
                   employees_register = rs.getDate("employees_register");
                   active = rs.getBoolean("active");
               }
           }
           connection.close();
           objEmployee = new EmployeesModel(Employees_id, Employees_startDate, Employees_salary, Employees_positionTitle, Employees_username, Employees_password, Employees_stopDate,Employees_active,user_id, speciality_id, role_id, employees_register, active);
           return objEmployee;
       }catch(SQLException e){
           e.getMessage();
           return null;
       }
   }
   
   //ELIMINAR UN REGISTRO
   public boolean deleteEmployee(int idBuscar){
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
   public boolean updateEmployee(EmployeesModel objEmployee){
       try{
            String sql = UPDATE + objEmployee.getEmployees_id();
            connection = con.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.setDate(1, objEmployee.getEmployees_startDate());
            statement.setFloat(2, objEmployee.getEmployees_salary());
            statement.setString(3, objEmployee.getEmployees_positionTitle());
            statement.setString(4, objEmployee.getEmployees_username());
            statement.setString(5, objEmployee.getEmployees_password());
            statement.setDate(6, objEmployee.getEmployees_stopDate());
            statement.setBoolean(7, objEmployee.isEmployees_active());
            statement.setInt(8, objEmployee.getSpeciality_id());
            statement.setInt(9, objEmployee.getRole_id());
            statement.setDate(10, objEmployee.getEmployees_register());
            statement.setInt(11, objEmployee.getUser_id());
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
