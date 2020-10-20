package com.hospitalcm.api;

//Importación de librerías
import com.hospitalcm.DAO.medicalConsultationDAO;
import com.hospitalcm.model.medicalConsultationModel;
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


@Path("/medicalConsultation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class medicalConsultationApi {
    medicalConsultationDAO objUse = new medicalConsultationDAO();
    
    /*Método POST: Utilizado para insertar una consulta medica en la tabla de
                   base de datos correspondiente
    */
    @POST
    public Response agregarUsuario(medicalConsultationModel registro) throws SQLException{
        
        boolean agregado = objUse.agregarMedicalConsultation(registro);  
        if (agregado){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(404, "Ocurrió un error al registrar la consulta medica").build();
        }
    }
    
    /*Método GET: Utilizado para seleccionar todos las consultas medicas en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<medicalConsultationModel> getTodasLasConsultas(){
        List<medicalConsultationModel> listamedicalConsultationModels = new ArrayList<medicalConsultationModel>();
        listamedicalConsultationModels = objUse.obtenerMedicalConsultations();
        
        return listamedicalConsultationModels;
    }
    
    /*Método GET: Utilizado para seleccionar  un usuario de pruebas en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public medicalConsultationModel getPruebaUsuario(@PathParam("id") int id){
        medicalConsultationModel objUsuario = new medicalConsultationModel();
        objUsuario = objUse.obtenerMedicalConsultation(id);
        
        if(objUsuario != null){
            return objUsuario;
        }else{
            return null;
        }
    }
    
    /*Método DELETE: Utilizado para eliminar un usuario de pruebas en la tabla 
                    de base de datos correspondiente
    */
    @DELETE
    @Path("/{id}")
    public Response eliminarPruebaUsuario(@PathParam("id") int id){
        boolean eliminado = objUse.eliminarMedicalCosultation(id);
        
        if(eliminado){
            return Response.status(200, "¡Usuario Eliminado Correctamente!").build();
        }else{
            return Response.status(500, "Ocurrió un error al tratar de eliminar el usuario, intente más tarde").build();   
        }
    }
    
    /*Método UPDATE: Utilizado para ACTUALIZAR un usuario de pruebas en la tabla 
                    de base de datos correspondiente
    */
    @PUT
    public Response actualizarUsuario(medicalConsultationModel registro) throws SQLException{
        
        boolean agregado = objUse.actualizarMedicalConsultation(registro);  
        if (agregado){
            return Response.status(200, "¡Registro actualizado exitosamente!").build();
        }else{
            return Response.status(404, "Ocurrió un error al registrar el usuario").build();
        }
        
    }
}
