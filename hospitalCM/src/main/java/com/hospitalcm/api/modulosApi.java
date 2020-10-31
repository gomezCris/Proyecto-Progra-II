
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.modulosDAO;
import com.hospitalcm.model.ModulosModel;
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

@Path("/modulos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class modulosApi {
    
     //Instanciamos el objeto DAO para poder acceder a sus métodos
    modulosDAO objModule = new modulosDAO();
    boolean res;
    /*Método POST: Utilizado para insertar un modulo en la tabla de
                   base de datos correspondiente
    */
    @POST
    
    public Response addModule(ModulosModel module){
        //Guarda el retorno de la operación del DAO
        res = objModule.addModule(module);
        
        //VAlida que la creación fue exitosa
        if(res){
            //REtorna una respuesta de tipo Json si este fue creado exitosamente
            return Response.status(Response.Status.CREATED).build();
        }else{
            //Retorna una respuesta de tipo Json con un mensaje de error
            return Response.status(400, "Ocurrió un error al registrar el modulo").build();
        }
    }
    
    /*Método GET: Utilizado para SELECCIONAR todos registros en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<ModulosModel> getModulos(){
         List<ModulosModel> listaModulos = new ArrayList<ModulosModel>();
         listaModulos = objModule.getModulos();
         return listaModulos;
    }
    
    /*Método GET: Utilizado para SELECCIONAR  un registro en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response getModule(@PathParam("id") int id){
        ModulosModel module = objModule.getModule(id);
        
        if(module.getModule_id() != 0){
            return Response.ok(module).build();
        }else if(module.getModule_id() == 0){
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
    public Response deleteModule(@PathParam("id") int id){
        res = objModule.deleteModule(id);
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
    public Response updateModule(ModulosModel module){
        res = objModule.updateModule(module);
        if(res){
            return Response.ok(module).build();
        }else{
            return Response.status(500, "Ocurrió un error al actualizar el usuario, intente más tarde").build();
        }
    }
}
