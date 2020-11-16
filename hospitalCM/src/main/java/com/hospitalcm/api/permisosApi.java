
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.permisosDAO;
import com.hospitalcm.model.PermisosModel;
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

@Path("/permisos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class permisosApi {
    
     //Instanciamos el objeto DAO para poder acceder a sus métodos
    permisosDAO objPermission = new permisosDAO();
    
    boolean res;
    /*Método POST: Utilizado para insertar un rol en la tabla de
                   base de datos correspondiente
    */
    @POST
    
    public Response addPermission(PermisosModel permission){
        //Guarda el retorno de la operación del DAO
        res = objPermission.addPermission(permission);
        
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
    public List<PermisosModel> getPermissions(){
         List<PermisosModel> listaPermisos = new ArrayList<PermisosModel>();
         listaPermisos = objPermission.getPermissions();
         return listaPermisos;
    }
    
    /*Método GET: Utilizado para SELECCIONAR  un registro en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response getPermission(@PathParam("id") int id){
        PermisosModel permission = objPermission.getPermission(id);
        
        if(permission.getPermission_Id() != 0){
            return Response.ok(permission).build();
        }else if(permission.getPermission_Id() == 0){
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
    public Response deletePermission(@PathParam("id") int id){
        res = objPermission.deletePermission(id);
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
    public Response updatePermission(PermisosModel permission){
        res = objPermission.updatePermission(permission);
        if(res){
            permission.setActive(true);
            return Response.ok(permission).build();
        }else{
            return Response.ok("Ocurrió un error al actualizar el registro, intente más tarde").build();
        }
    }
}
