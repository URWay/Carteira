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

import br.com.urway.nocash.dao.DAOFactory;
import br.com.urway.nocash.dao.interf.*;
import br.com.urway.nocash.model.Movimento;

/**
 * Contém serviços do movimento
 */
@Path("/movimento")
public class MovimentoService {

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovimentos(String acao, String data){
        List<Movimento> mov;
        try{
            IDAOMovimento dao = DAOFactory.getMovimentoDAO();
            mov = dao.procurar(acao, data);
        } catch(Exception ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
        
        return Response.ok(mov).build();
    }*/
}
