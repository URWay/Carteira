package Parceiro;

import Cliente.*;
import daos.DaoException;
import daos.DaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONObject;



public class ParceiroDaoJdbc extends DaoJdbc implements ClienteDao {
    
    public ParceiroDaoJdbc(String driver, String url, String user, String pass){
        super(driver, url, user, pass);
    }
    
    @Override
    public List<Cliente> findAll() throws DaoException {
        
        List<Cliente> cliente = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("select * from Cliente order by nome");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idCliente");
                    String nome = rs.getString("nomeCliente");
                    String sobre = rs.getString("sobreCliente");
                    String email = rs.getString("emailCliente");
                    String cep = rs.getString("cepCliente");
                    String cpf = rs.getString("cpfCliente");
                    String rg = rs.getString("rgCliente");
                    Timestamp dtNasc = rs.getTimestamp("dtNasc");
                    String sexo = rs.getString("sexo");
                    int tel = rs.getInt("telCliente");
                    int cel = rs.getInt("celCliente");
                    Timestamp registro = rs.getTimestamp("dtRegistro");
                    
                    Cliente clientes = new Cliente(id, nome, sobre, email, cep, cpf, rg, dtNasc, sexo, tel, cel, registro);
                    cliente.add(clientes);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return cliente;
    }
    
    //@POST
    //@Path("/inserir")
   // @Produces(MediaType.APPLICATION_JSON)
 //   @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public boolean insert(String content) throws Exception{
        JSONObject object = new JSONObject(content);        
        String nomeCliente = object.getString("nomeCliente");
        String sobreCliente = object.getString("sobreCliente");
        String emailCliente = object.getString("emailCliente");
        String cepCliente = object.getString("cepCliente");
        String cpfCliente = object.getString("cpfCliente");
        String rgCliente = object.getString("rgCliente");        
        String dtNascS = object.getString("dtNasc");
        String sexo = object.getString("sexo");
        int telCliente = object.getInt("telCliente");
        int celCliente = object.getInt("celCliente");
        String dtRegistroS = object.getString("dtRegistro");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = (java.sql.Date) sdf.parse(dtRegistroS);
        Timestamp dtRegistro = new Timestamp(data.getTime());
        data = (java.sql.Date) sdf.parse(dtNascS);
        Timestamp dtNasc = new Timestamp(data.getTime());
        
        Cliente cliente = new Cliente(0, nomeCliente, sobreCliente, emailCliente, cepCliente, cpfCliente, rgCliente, dtNasc,sexo,telCliente,celCliente,dtRegistro);
        
        String sql = "INSERT INTO cliente ("
                + "nomeCliente, "
                + "sobreCliente, "
                + "emailCliente, "
                + "cepCliente, "
                + "cpfCliente, "
                + "rgCliente, "
                + "dtNasc, "
                + "sexo, "
                + "telCliente, "
                + "celCliente, "
                + "dtRegistro ) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            
            Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql);
                        
            try {
            
                
                ps.setString(1, nomeCliente);
                ps.setString(2, sobreCliente);
                ps.setString(3, emailCliente); 
                ps.setString(4, cepCliente);
                ps.setString(5, cpfCliente);
                ps.setString(6, rgCliente);
                ps.setTimestamp(7, dtNasc);
                ps.setString(8, sexo);
                ps.setInt(9, telCliente);
                ps.setInt(10, celCliente);
                ps.setTimestamp(11, dtRegistro);
                
             // if(ps.executeUpdate() > 0){
              //      return Response.status(200).entity(cliente).build();
               // } else {
                 //   return Response.status(404).build();
                //}

            } catch(SQLException 
                    ex){
                throw new DaoException(ex);
            }
       
        } catch(Exception ex){
            throw new DaoException(ex);
        }      
        return true;
    }
    
  //  @PUT
   // @Path("/update")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Override
    public boolean update(String content) throws Exception{
        // Verificar se jÃ¡ exite email igual
       
            JSONObject object = new JSONObject(content); 
            int idCliente = object.getInt("idCliete");
            String nomeCliente = object.getString("nomeCliente");
            String sobreCliente = object.getString("sobreCliente");
            String emailCliente = object.getString("emailCliente");
            String cepCliente = object.getString("cepCliente");
            String cpfCliente = object.getString("cpfCliente");
            String rgCliente = object.getString("rgCliente");        
            String dtNascS = object.getString("dtNasc");
            String sexo = object.getString("sexo");
            int telCliente = object.getInt("telCliente");
            int celCliente = object.getInt("celCliente");
            String dtRegistroS = object.getString("dtRegistro");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = (java.sql.Date) sdf.parse(dtRegistroS);
            Timestamp dtRegistro = new Timestamp(data.getTime());
            data = (java.sql.Date) sdf.parse(dtNascS);
            Timestamp dtNasc = new Timestamp(data.getTime());
        
            Cliente cliente = new Cliente(0, nomeCliente, sobreCliente, emailCliente, cepCliente, cpfCliente, rgCliente, dtNasc,sexo,telCliente,celCliente,dtRegistro);
         try {
            Connection conn = getConnection(); 
            
             String sql = "UPDATE cliente SET"
                + "nomeClient =  ?,"
                + "sobreCliente = ?, "
                + "emailCliente = ?, "
                + "cepCliente = ?, "
                + "cpfCliente = ?, "
                + "rgCliente = ?, "
                + "dtNasc = ?, "
                + "sexo = ?, "
                + "telCliente = ?, "
                + "celCliente = ?, "
                + "dtRegistro = ?   "
                + "WHERE idCliente = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nomeCliente);
            ps.setString(2, sobreCliente);
            ps.setString(3, emailCliente); 
            ps.setString(4, cepCliente);
            ps.setString(5, cpfCliente);
            ps.setString(6, rgCliente);
            ps.setTimestamp(7, dtNasc);
            ps.setString(8, sexo);
            ps.setInt(9, telCliente);
            ps.setInt(10, celCliente);
            ps.setTimestamp(11, dtRegistro);
            ps.setInt(12, idCliente);
            ResultSet rs = ps.executeQuery();
            
           // if(rs != null){
             //   if(rs.next()){
               //     return Response.ok().build();
                //}else {
                 //   return Response.status(204).build();
              //  }
            //}   
            
       } catch(Exception ex){
          throw ex;
       }
        
        return true;
    }
    
  
}
