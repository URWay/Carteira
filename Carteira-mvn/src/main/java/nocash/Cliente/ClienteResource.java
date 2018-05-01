package nocash.Cliente;

import nocash.daos.DaoException;
import nocash.daos.DaoFactory;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    //@Path("/inserir")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirCliente(){
        try{
            ClienteDao dao = DaoFactory.getClienteDao();
            List<Cliente> cliente = dao.findAll();
            return Response.ok(new Clientes(cliente)).build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
}
