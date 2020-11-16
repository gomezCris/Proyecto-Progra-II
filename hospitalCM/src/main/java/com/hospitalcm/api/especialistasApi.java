
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.especialistasDAO;
import com.hospitalcm.model.EspecialistasModel;
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

@Path("/especialistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class especialistasApi {
      //Instanciamos el objeto DAO para poder acceder a sus métodos
    especialistasDAO objSpeciality = new especialistasDAO ();
    boolean res;
    
    /*Método POST: Utilizado para insertar una especialiad en la tabla de
                   base de datos correspondiente
    */
    @POST
    public Response addSpeciality(EspecialistasModel Speciality){
        
        //Guarda el retorno de la operación del DAO
        res = objSpeciality.addSpeciality(Speciality);
      
        //VAlida que la creación fue exitosa
        if(res){
            //REtorna una respuesta de tipo Json si este fue creado exitosamente
            return Response.ok("Registro creado correctamente").build();
        }else{
            //Retorna una respuesta de tipo Json con un mensaje de error
            return Response.ok("Ocurrió un error al agregar el registro ").build();
        }
    }
    
    /*Método GET: Utilizado para SELECCIONAR todos registros en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<EspecialistasModel> getEspecialistas(){
         List<EspecialistasModel> listaEspecialistas = new ArrayList<EspecialistasModel>();
         listaEspecialistas = objSpeciality.getEspecialistas();
         return listaEspecialistas;
    }
    
    /*Método GET: Utilizado para SELECCIONAR  un registro en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response getEspecialidad(@PathParam("id") int id){
         EspecialistasModel objEspecialidad = objSpeciality.getSpeciality(id);
         
         if(objEspecialidad.getSpeciality_id() != 0){
             return Response.ok(objEspecialidad).build();
         }else if(objEspecialidad.getSpeciality_id() == 0){
             return Response.ok("Registro no encontrado en base de datos").build();
         }else{
             return Response.ok("Ocurrió un error al consultar el registro").build();
         }
    }
    
    /*Método DELETE: Utilizado para ELIMINAR un registro en la tabla 
                    de base de datos correspondiente
    */
    @DELETE
    @Path("/{id}")
    public Response deleteSpeciality(@PathParam("id") int id){
        res = objSpeciality.deleteSpeciality(id);
        if(res){
            return Response.ok("Registro eliminado correctamente").build();
        }else{
            return Response.ok("Ocurrió un error al eliminar el registro").build();
        }
    }
    
    /*Método PUT: Utilizado para ACTUALIZAR un registro en la tabla 
                    de base de datos correspondiente
    */
    @PUT
    public Response updateSpeciality(EspecialistasModel objEspecialidad){
        res = objSpeciality.updateSpeciality(objEspecialidad);
        if(res){
            objEspecialidad.setActive(true);
            return Response.ok(objEspecialidad).build();
        }else{
            return Response.ok("Ocurrió un error al actualizar el registro, intente más tarde").build();
        }
    }
}
