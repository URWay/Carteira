/**
 * 
 */
package br.com.urway.nocash.dao;


import br.com.urway.nocash.dao.impl.DAOCliente;
import br.com.urway.nocash.dao.impl.DAOUsuario;
import br.com.urway.nocash.dao.interf.IDAOCliente;
import br.com.urway.nocash.dao.interf.IDAOUsuario;

/**
 * Fábrica de DAOs
 */
public class DAOFactory {

	public static IDAOUsuario getUsuarioDAO() {
		return new DAOUsuario();
	}
        public static IDAOCliente getClienteDAO() {
		return new DAOCliente();
	}
}
