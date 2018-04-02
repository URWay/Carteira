package usuarios;

import daos.DaoException;
import java.util.List;

public interface UsuarioDao {
    
    List<Usuario> findAll() throws DaoException;
    
    
}
