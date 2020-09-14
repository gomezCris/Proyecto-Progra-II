package com.hospitalcm.api;

//Importación de librerías
import com.hospitalcm.DAO.pruebaApiUsuarioDAO;
import com.hospitalcm.model.pruebaApiUsuario;
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
 * @author Cristian Coronado
 */
@Path("/pruebaUsuarioApi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class pruebaUsuarioApi {
    pruebaApiUsuarioDAO testAPI = new pruebaApiUsuarioDAO();
    
    @POST
    public Response agregarUsuario(pruebaApiUsuario registro) throws SQLException{
        
        boolean agregado = testAPI.agregarPruebaApiUsuario(registro);  
        if (agregado){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(404, "Ocurrió un error al registrar el usuario").build();
        }
        
    }
    
    @GET
    public List<pruebaApiUsuario> getTodosUsuarios(){
        List<pruebaApiUsuario> listapruebaApiUsuarios = new ArrayList<pruebaApiUsuario>();
        listapruebaApiUsuarios = testAPI.obtenerPruebaApiUsuarios();
        
        return listapruebaApiUsuarios;
    }
    
    @GET
    @Path("/{id}")
    public List<pruebaApiUsuario> getPruebaUsuario(@PathParam("id") int id){
        List<pruebaApiUsuario> listapruebaApiUsuario = new ArrayList<pruebaApiUsuario>();
        listapruebaApiUsuario = testAPI.obtenerPruebaApiUsuario(id);
        
        return listapruebaApiUsuario;
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminarPruebaUsuario(@PathParam("id") int id){
        boolean eliminado = testAPI.eliminarPruebaApiUsuario(id);
        
        if(eliminado){
            return Response.status(200, "¡Usuario Eliminado Correctamente!").build();
        }else{
            return Response.status(500, "Ocurrió un error al tratar de eliminar el usuario").build();   
        }
    }
}
