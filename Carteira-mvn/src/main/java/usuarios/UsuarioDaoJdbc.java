package usuarios;

import daos.DaoException;
import daos.DaoJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJdbc extends DaoJdbc implements UsuarioDao {
    
    public UsuarioDaoJdbc(String driver, String url, String user, String pass){
        super(driver, url, user, pass);
    }
    
    @Override
    public List<Usuario> findAll() throws DaoException {
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("select * from Usuario order by nome");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idUsuario");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    String permissoes = rs.getString("fkpermissoes");
                    int configuracoes = rs.getInt("fkConfiguracoes");
                    
                    Usuario usuario = new Usuario(id, nome, email, senha, permissoes, configuracoes);
                    usuarios.add(usuario);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }
        
        return usuarios;
    }
}
