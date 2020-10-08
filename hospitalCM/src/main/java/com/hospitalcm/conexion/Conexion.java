package com.hospitalcm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author Cristian Coronado
 */
public class Conexion {
    Connection con;
     BasicDataSource dataSource = null;
     
     DataSource getDataSource(){
         if(dataSource == null){
             dataSource = new BasicDataSource();
             dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
             dataSource.setUsername("gearsgtc_javaser");
             dataSource.setPassword("Nfyxrz15ne03");
             dataSource.setUrl("jdbc:mysql://dnzmakers.com:3306/gearsgtc_java_hospital?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false");
             dataSource.setInitialSize(20);
             dataSource.setMaxIdle(15);
             dataSource.setMaxTotal(1);
             dataSource.setMaxWaitMillis(5000);
         }
         return dataSource;
     }
    //conexión a DB
    public Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
}
