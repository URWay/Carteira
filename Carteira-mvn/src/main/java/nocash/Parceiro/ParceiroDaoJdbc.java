package nocash.Parceiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nocash.daos.DaoException;
import nocash.daos.DaoJdbc;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ParceiroDaoJdbc extends DaoJdbc implements ParceiroDao {
    
    public ParceiroDaoJdbc(String driver, String url, String user, String pass){
        super(driver, url, user, pass);
    }
    
    @Override
    public List<Parceiro> findAll() throws DaoException {
        
        List<Parceiro> parceiros = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("select * from Parceiro order by razaoParceiro");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idParceiro");
                    String CNPJ = rs.getString("CNPJ");
                    String email = rs.getString("emailParceiro");
                    String razao = rs.getString("razaoParceiro");
                    String cpf = rs.getString("cpfParceiro");
                    
                    Parceiro parceiro = new Parceiro(id, CNPJ, email, razao, cpf);
                    parceiros.add(parceiro);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return parceiros;
    }
    
    @Override
    public void insert(String content) throws Exception{
        
        try {
            
            JSONObject object = new JSONObject(content);        
        
            String CNPJ = object.getString("CNPJ");
            String email = object.getString("emailParceiro");
            String razao = object.getString("razaoParceiro");
            String cpf = object.getString("cpfParceiro");

            String sql = "INSERT INTO parceiro ("
                    + "CNPJ, "
                    + "emailParceiro, "
                    + "razaoParceiro, "
                    + "cpfParceiro)"
                    + "VALUES(?,?,?,?)";

            Connection conn = getConnection(); 
            PreparedStatement ps = conn.prepareStatement(sql);

            try {
                
                ps.setString(1, CNPJ);
                ps.setString(2, email);
                ps.setString(3, razao); 
                ps.setString(4, cpf);
                
                if (ps.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next()) {
                            throw new SQLException("Id não foi criado!");
                        }
                    }
                }
                
            } catch(SQLException 
                    ex){
                throw new DaoException(ex);
            }
       
        } catch(ClassNotFoundException | SQLException | DaoException ex){
            throw new DaoException(ex);
        }
    }
    
    @Override
    public boolean update(String content) throws Exception{
       
         try {
             
            JSONObject object = new JSONObject(content); 
            
            int id = object.getInt("idParceiro");
            String CNPJ = object.getString("CNPJ");
            String email = object.getString("emailParceiro");
            String razao = object.getString("razaoParceiro");
            String cpf = object.getString("cpfParceiro");
            
            Connection conn = getConnection(); 
            
             String sql = "UPDATE parceiro SET"
                + "CNPJ =  ?,"
                + "emailParceiro = ?, "
                + "razaoParceiro = ?, "
                + "cpfParceiro = ? "
                + "WHERE idParceiro = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, CNPJ);
            ps.setString(2, email);
            ps.setString(3, razao); 
            ps.setString(4, cpf);
            ps.setInt(5, id);
            
            if(ps.executeUpdate() <= 0){
                throw new SQLException("O registro não pode ser atualizado!");
            }            
       } catch(JSONException | ClassNotFoundException | SQLException ex){
          throw ex;
       }
        
        return true;
    }
    
}
