package nocash.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import nocash.daos.DaoException;
import nocash.daos.DaoJdbc;
import validacoes.valid;

import org.codehaus.jettison.json.JSONObject;

public class ClienteDaoJdbc extends DaoJdbc implements ClienteDao {
    
    private valid valid;

    public ClienteDaoJdbc(String driver, String url, String user, String pass){
        super(driver, url, user, pass);
    }
    
    @Override
    public List<Cliente> findAll() throws DaoException {
        
        List<Cliente> cliente = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("select * from Cliente order by nomeCliente");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idCliente");
                    int tel = rs.getInt("telCliente");
                    int cel = rs.getInt("celCliente");
                    
                    String nome = rs.getString("nomeCliente");
                    String sobre = rs.getString("sobreCliente");
                    String email = rs.getString("emailCliente");
                    String cep = rs.getString("cepCliente");
                    String cpf = rs.getString("cpfCliente");
                    String rg = rs.getString("rgCliente");
                    String sexo = rs.getString("sexo");
                    
                    Timestamp dtNasc = rs.getTimestamp("dtNasc");
                    Timestamp registro = rs.getTimestamp("dtRegistro");
                    
                    Cliente clientes = new Cliente(id, nome, sobre, email, cep, cpf, rg, dtNasc, sexo, tel, cel, registro, "", "");
                    cliente.add(clientes);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return cliente;
    }
    
    @Override
    public void insert(String content) throws Exception {
        
        try {
            
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
            String senha = object.getString("senhaCliente");

            // PasswordHash
            String generatedSecuredPasswordHash = valid.generateStrongPasswordHash(senha);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = (java.sql.Date) sdf.parse(dtRegistroS);
            Timestamp dtRegistro = new Timestamp(data.getTime());
            data = (java.sql.Date) sdf.parse(dtNascS);
            Timestamp dtNasc = new Timestamp(data.getTime());
            
            Cliente cliente = new Cliente(0, nomeCliente, sobreCliente, emailCliente, cepCliente, cpfCliente, rgCliente, dtNasc,sexo,telCliente,celCliente,dtRegistro, senha, "");
            
            if(!cliente.isValid("I")){
                throw new IllegalArgumentException("cliente");
            }
            
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
                    + "dtRegistro, ) "
                    + "senha) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

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
                ps.setString(12, generatedSecuredPasswordHash);
                
                if (ps.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            int id = rs.getInt("idCliente");
                            cliente.setIdCliente(id);
                        } else {
                            throw new SQLException("Id não foi criado!");
                        }
                    }
                }
                
            } catch(SQLException ex){
                throw new DaoException(ex);
            }
       
        } catch(ClassNotFoundException | SQLException | DaoException ex){
            throw new DaoException(ex);
        }
        
    }
    
    @Override
    public void update(String content) throws Exception {
        
        try {
            
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
        
            Cliente cliente = new Cliente(idCliente, nomeCliente, sobreCliente, emailCliente, cepCliente, cpfCliente, rgCliente, dtNasc,sexo,telCliente,celCliente,dtRegistro, "", "");
            
            if(cliente.isValid("A")){
                throw new IllegalArgumentException("cliente");
            }
        
            try {
                Connection conn = getConnection(); 
            
                String sql = "UPDATE cliente SET"
                   + "nomeCliente =  ?,"
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
                
                if(ps.executeUpdate() <= 0){
                    throw new SQLException("O registro não pode ser atualizado!");
                }

           } catch(SQLException ex){
                throw new DaoException(ex);
            }
       
        } catch(ClassNotFoundException | DaoException ex){
            throw new DaoException(ex);
        } 
        
    }
    
    @Override
    public Cliente Login(String email, String senha) throws DaoException {
        
        Cliente cliente = new Cliente(0, "", "", "", "", "", "", null, "", 0, 0, null, "", "");

        try {
            try (Connection conn = getConnection()) {
                    
                    // Valida a senha
                    boolean matched = valid.validatePassword("password", senha);

                    PreparedStatement stmt = conn.prepareStatement("select top(1) * from Cliente where emailCliente = ? AND senha = ?");
                    stmt.setString(1, email);
                    stmt.setString(2, matched);
                    ResultSet rs = stmt.executeQuery(); 

                    while (rs.next()) {
                        int id = rs.getInt("idCliente");
                        String nome = rs.getString("nomeCliente");
                        String sobre = rs.getString("sobreCliente");
                        String cep = rs.getString("cepCliente");
                        String cpf = rs.getString("cpfCliente");
                        String rg = rs.getString("rgCliente");
                        Timestamp dtNasc = rs.getTimestamp("dtNasc");
                        String sexo = rs.getString("sexo");
                        int tel = rs.getInt("telCliente");
                        int cel = rs.getInt("celCliente");
                        Timestamp registro = rs.getTimestamp("dtRegistro");

                        cliente = new Cliente(id, nome, sobre, email, cep, cpf, rg, dtNasc,sexo,tel,cel,registro, "", "");
                    }
            }
        } catch(ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return cliente;
    }

}
