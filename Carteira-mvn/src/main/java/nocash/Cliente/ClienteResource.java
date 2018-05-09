package nocash.Cliente;

import nocash.daos.DaoException;
import nocash.daos.DaoFactory;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(){
        try{
            ClienteDao dao = DaoFactory.getClienteDao();
            List<Cliente> cliente = dao.findAll();
            return Response.ok(new Clientes(cliente)).build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirCliente(String content) throws Exception {
        try{
            ClienteDao dao = DaoFactory.getClienteDao();
            dao.insert(content);
            return Response.ok().build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(String content) throws Exception {
        try {
            ClienteDao dao = DaoFactory.getClienteDao();
            dao.update(content);
            return Response.ok().build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(String content) {
        try {
        	System.out.println(content);
            ClienteDao dao = DaoFactory.getClienteDao();
            Cliente cliente = dao.Login(content);
            return Response.ok(cliente).header("Access-Control-Allow-Origin", "*").build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
}
