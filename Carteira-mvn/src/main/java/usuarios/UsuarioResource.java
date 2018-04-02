package usuarios;

import daos.DaoException;
import daos.DaoFactory;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios(){
        try{
            UsuarioDao dao = DaoFactory.getCategoriaDao();
            List<Usuario> usuarios = dao.findAll();
            return Response.ok(new Usuarios(usuarios)).build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
}
