/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalcm.api;

//Importación de librerías
import com.hospitalcm.DAO.pruebaApiUsuarioDAO;
import com.hospitalcm.model.pruebaApiUsuario;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes; 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response;

/**
 *
 * @author Cristian Coronado
 */
@Path("pruebaUsuarioApi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class pruebaUsuarioApi {
    
    @GET
    public Response getApiUsuarios(){
        return Response.ok().build();
    }
    
    @POST
    public Response agregarUsuario(pruebaApiUsuario registro) throws SQLException{
        
        pruebaApiUsuarioDAO testAPI = new pruebaApiUsuarioDAO();
        
        boolean agregado = testAPI.agregarPruebaApiUsuario(registro);  
        if (agregado){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(404, "Ocurrió un error al registrar el usuario").build();
        }
        
    }
    
}
