package Cliente;

import Cliente.*;
import daos.DaoException;
import daos.DaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJdbc extends DaoJdbc implements ClienteDao {
    
    public ClienteDaoJdbc(String driver, String url, String user, String pass){
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
                    String dtNasc = rs.getString("dtNasc");
                    String sexo = rs.getString("sexo");
                    int tel = rs.getInt("telCliente");
                    int cel = rs.getInt("celCliente");
                    String registro = rs.getString("dtRegistro");
                    
                    Cliente clientes = new Cliente(id, nome, sobre, email, cep, cpf, rg, dtNasc, sexo, tel, cel, registro);
                    cliente.add(clientes);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return cliente;
    }
}
