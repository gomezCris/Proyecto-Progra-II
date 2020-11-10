/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.api;

//Importación de librerías
import com.hospitalcm.DAO.medicalDiagnosticDAO;
import com.hospitalcm.model.MedicalDiagnosticModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes; 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response;

/**
 *
 * @author Denzil Barrios
 * GoDevs Team-2,020
 */

@Path("/medicalDiagnostic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class medicalDiagnosticApi {
    medicalDiagnosticDAO objUse = new medicalDiagnosticDAO();
    
    /*Método POST: Utilizado para insertar una consulta medica en la tabla de
                   base de datos correspondiente
    */
    @POST
    public Response agregar(MedicalDiagnosticModel registro) throws SQLException{
        
        boolean agregado = objUse.agregarDAO(registro);  
        if (agregado){
            return Response.ok("Registro creado correctamente").build();
        }else{
            return Response.ok("Ocurrió un error al agregar el registro ").build();
        }
    }
    
    /*Método GET: Utilizado para seleccionar todos las consultas medicas en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<MedicalDiagnosticModel> todos(){
        List<MedicalDiagnosticModel> listaTodos = new ArrayList<MedicalDiagnosticModel>();
        listaTodos = objUse.obtenerTodosDAO();
        
        return listaTodos;
    }
    
    /*Método GET: Utilizado para seleccionar  un usuario de pruebas en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response registro(@PathParam("id") int id){
        MedicalDiagnosticModel objRegistro = objUse.obtenerDAO(id);
        
        if(objRegistro.getMd_id() != 0){
            return Response.ok(objRegistro).build();
        }else if(objRegistro.getMd_id() == 0){
            return Response.ok("Registro no encontrado en base de datos").build();
        }else{
            return Response.ok("Ocurrió un error al consultar el registro").build();
        }
    }
    
    /*Método DELETE: Utilizado para eliminar un usuario de pruebas en la tabla 
                    de base de datos correspondiente
    */
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        boolean eliminado = objUse.eliminarDAO(id);
        
        if(eliminado){
             return Response.ok("Registro eliminado correctamente").build();
        }else{
            return Response.ok("Ocurrió un error al eliminar el registro").build();
        }
    }
    
    /*Método UPDATE: Utilizado para ACTUALIZAR un usuario de pruebas en la tabla 
                    de base de datos correspondiente
    */
    @PUT
    public Response actualizar(MedicalDiagnosticModel registro) throws SQLException{
        
        boolean agregado = objUse.actualizarDAO(registro);  
        if (agregado){
            return Response.ok(registro).build();
        }else{
            return Response.ok("Ocurrió un error al actualizar el registro, intente más tarde").build();
        }
        
    }
}
