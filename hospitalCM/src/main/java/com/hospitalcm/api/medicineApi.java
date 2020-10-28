/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.api;

//Importación de librerías
import com.hospitalcm.DAO.medicineDAO;
import com.hospitalcm.model.MedicineModel;
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

@Path("/medicine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class medicineApi {
    medicineDAO objUse = new medicineDAO();
    
    /*Método POST: Utilizado para insertar una consulta medica en la tabla de
                   base de datos correspondiente
    */
    @POST
    public Response agregar(MedicineModel registro) throws SQLException{
        
        boolean agregado = objUse.agregarDAO(registro);  
        if (agregado){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(404, "Ocurrió un error al insertar el registro").build();
        }
    }
    
    /*Método GET: Utilizado para seleccionar todos las consultas medicas en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<MedicineModel> todos(){
        List<MedicineModel> listaTodos = new ArrayList<MedicineModel>();
        listaTodos = objUse.obtenerTodosDAO();
        
        return listaTodos;
    }
    
    /*Método GET: Utilizado para seleccionar  un usuario de pruebas en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public MedicineModel registro(@PathParam("id") int id){
        MedicineModel objRegistro = new MedicineModel();
        objRegistro = objUse.obtenerDAO(id);
        
        if(objRegistro != null){
            return objRegistro;
        }else{
            return null;
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
            return Response.status(200, "¡Eliminado Correctamente!").build();
        }else{
            return Response.status(500, "Ocurrió un error al tratar de eliminar el registro, intente más tarde").build();   
        }
    }
    
    /*Método UPDATE: Utilizado para ACTUALIZAR un usuario de pruebas en la tabla 
                    de base de datos correspondiente
    */
    @PUT
    public Response actualizar(MedicineModel registro) throws SQLException{
        
        boolean agregado = objUse.actualizarDAO(registro);  
        if (agregado){
            return Response.status(200, "¡Registro actualizado exitosamente!").build();
        }else{
            return Response.status(404, "Ocurrió un error al actualizar el registro").build();
        }
        
    }    
}
