package nocash.Parceiro;

import nocash.daos.DaoException;
import java.util.List;

public interface ParceiroDao {   
    List<Parceiro> findAll() throws DaoException;
    
    void insert(String par) throws Exception;
    
    boolean update(String par) throws Exception;
}
