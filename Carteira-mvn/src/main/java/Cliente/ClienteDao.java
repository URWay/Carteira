/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import daos.DaoException;
import java.util.List;

/**
 *
 * @author augusto.naraujo
 */
public interface ClienteDao {
    List<Cliente> findAll() throws DaoException;
    boolean insert(String cli) throws Exception;
    boolean update(String cli) throws Exception;
}
