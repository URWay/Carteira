/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nocash.Cliente;
import nocash.daos.DaoException;
import java.util.List;

/**
 *
 * @author augusto.naraujo
 */
public interface ClienteDao {
    List<Cliente> findAll() throws DaoException;
    Cliente insert(String cli) throws DaoException;
    Cliente update(String cli) throws DaoException, Exception;
    Cliente inserir(String content) throws Exception;
}
