
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.patientsDAO;
import com.hospitalcm.model.Patients_Model;
//Importación de librerías
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

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class patientsApi {
    
       //Instanciamos el objeto DAO para poder acceder a sus métodos
    patientsDAO objPatients = new patientsDAO();
    
    boolean res;
    /*Método POST: Utilizado para insertar un rol en la tabla de
                   base de datos correspondiente
    */
    @POST
    
    public Response addPatients(Patients_Model patients){
        //Guarda el retorno de la operación del DAO
        res = objPatients.addPatient(patients);
         
        
        
        //Valida que la creación fue exitosa
        if(res){
            //eEtorna una respuesta de tipo Json si este fue creado exitosamente
            return Response.status(Response.Status.CREATED).build();
        }else{
            //Retorna una respuesta de tipo Json con un mensaje de error
            return Response.status(400, "Ocurrió un error al registrar el paciente").build();
        }
    }
    
    /*Método GET: Utilizado para SELECCIONAR todos registros en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<Patients_Model> getPatients(){
         List<Patients_Model> listaPatients = new ArrayList<Patients_Model>();
         listaPatients  = objPatients.getPatients();
         return listaPatients;
    }
    
    /*Método GET: Utilizado para SELECCIONAR  un registro en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response getPatient(@PathParam("id") int id){
        Patients_Model objPatient = objPatients.getPatient(id);
        
        if(objPatient.getPatient_id() != 0){
            return Response.ok(objPatient).build();
        }else if(objPatient.getPatient_id() == 0){
            return Response.status(200, "Registro no encontrado en base de datos").build();
        }else{
            return Response.status(500, "Ocurrió un error al consultar el registro").build();
        }
    }
    
    /*Método DELETE: Utilizado para ELIMINAR un registro en la tabla 
                    de base de datos correspondiente
    */
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id){
        res = objPatients.deletePatient(id);
        if(res){
            return Response.status(200, "Registro eliminado correctamente").build();
        }else{
            return Response.status(500, "Ocurrió un error al eliminar el registro").build();
        }
    }
    
    /*Método PUT: Utilizado para ACTUALIZAR un registro en la tabla 
                    de base de datos correspondiente
    */
    @PUT
    public Response updatePatient(Patients_Model objPatient){
        res = objPatients.updatePatient(objPatient);
        if(res){
            return Response.ok(objPatient).build();
        }else{
            return Response.status(500, "Ocurrió un error al actualizar el usuario, intente más tarde").build();
        }
    }
}
