package nocash.Movimento;

import java.util.List;
import nocash.daos.DaoException;

public interface MovimentoDao {
    
    List<Movimento> findAll() throws DaoException;
    
    Movimento insert(Movimento mov) throws DaoException;
    
    Movimento update(Movimento mov) throws DaoException;
}
