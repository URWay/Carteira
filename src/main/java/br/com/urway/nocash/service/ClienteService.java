/**
 * Classes de serviço, versão 1.0
 */
package br.com.urway.nocash.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.annotate.JsonRawValue;

//import br.com.urway.nocash.constant.MainConstants;
import br.com.urway.nocash.dao.DAOFactory;
import br.com.urway.nocash.dao.interf.*;
import br.com.urway.nocash.model.Cliente;
import br.com.urway.nocash.model.Usuario;

/**
 * Contém serviços de usuários
 */
//@Path(MainConstants.SERVICES_V1 + "/usuarios")
@Path("/clientes")
public class ClienteService {
    /** Instância do logger **/
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes(){
        List<Cliente> clientes = null;
        try{
            IDAOCliente dao = DAOFactory.getClienteDAO();
            clientes = dao.procurar("x");
        } catch(Exception ex){
            LOGGER.log(Level.SEVERE, "Falha na execução do DAO de Usuario", ex);
            Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                            .entity("Ocorreu uma falha ao buscar usuarios. "
                                            + "Verifique o log do servidor para maiores detalhes").build();
            return Response.serverError().entity(ex.getMessage()).build();
        }
        
        return Response.ok(clientes).build();
    }
    /*
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
    */

}
