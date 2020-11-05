
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.usersDAO;
import com.hospitalcm.model.Users_Model;
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

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class usersApi {
    
      //Instanciamos el objeto DAO para poder acceder a sus métodos
    usersDAO objUse = new usersDAO();
    boolean res;
    /*Método POST: Utilizado para insertar un rol en la tabla de
                   base de datos correspondiente
    */
    @POST
    public Response addUse(Users_Model use){
        //Guarda el retorno de la operación del DAO
        res = objUse.addUse(use);
        
        //VAlida que la creación fue exitosa
        if(res){
            //REtorna una respuesta de tipo Json si este fue creado exitosamente
            return Response.ok("Registro creado correctamente").build();
        }else{
            //Retorna una respuesta de tipo Json con un mensaje de error
            return Response.ok("Ocurrió un error al registrar el usuario ").build();
        }
    }
    
     /*Método GET: Utilizado para SELECCIONAR todos registros en la tabla de 
                base de datos correspondiente
    */
    @GET
    public List<Users_Model> getUsers(){
         List<Users_Model> listaUsers = new ArrayList<Users_Model>();
         listaUsers = objUse.getUsers();
         return listaUsers;
    }
    
    /*Método GET: Utilizado para SELECCIONAR  un registro en la tabla 
                de base de datos correspondiente por medio de su ID
    */
    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id){
        Users_Model user = objUse.getUse(id);
        
        if(user.getUser_id() != 0){
            return Response.ok(user).build();
        }else if(user.getUser_id() == 0){
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
    public Response deleteUser(@PathParam("id") int id){
        res = objUse.deleteUse(id);
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
    public Response updateUser(Users_Model use){
        res = objUse.updateUse(use);
        if(res){
            return Response.ok(use).build();
        }else{
            return Response.ok("Ocurrió un error al actualizar el usuario, intente más tarde").build();
        }
    }
}
