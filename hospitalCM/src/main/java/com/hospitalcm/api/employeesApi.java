
package com.hospitalcm.api;

//Importación de clase
import com.hospitalcm.DAO.employeesDAO;
import com.hospitalcm.model.EmployeesModel;
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

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class employeesApi {
    
     //Instanciamos el objeto DAO para poder acceder a sus métodos
    employeesDAO objEmployee = new employeesDAO();
    
    /*Método POST: Utilizado para insertar un empleado en la tabla de
                   base de datos correspondiente
    */
    @POST
    
    public Response addEmployee(EmployeesModel employee){
       
        
        //Guarda el retorno de la operación del DAO
        boolean result = objEmployee.addEmployee(employee);
        
        //VAlida que la creación fue exitosa
        if(result){
            //REtorna una respuesta de tipo Json si este fue creado exitosamente
            return Response.status(Response.Status.CREATED).build();
        }else{
            //Retorna una respuesta de tipo Json con un mensaje de error
            return Response.status(400, "Ocurrió un error al registrar el empleado").build();
        }
    }
    
}
