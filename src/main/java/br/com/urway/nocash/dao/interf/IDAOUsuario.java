/**
 * Interfaces de objetos de acesso a dados
 */
package br.com.urway.nocash.dao.interf;

import java.util.List;

import br.com.urway.nocash.model.Usuario;

/**
 * Define um DAO de Usuários
 */
public interface IDAOUsuario extends IDAO<Usuario> {

	/**
	 * Procura por elementos que atendam aos critérios (usado para realizar
	 * autenticação de usuário)
	 * 
	 * @param username
	 *            o username do usuário
	 * @param password
	 *            o password do usuário
	 * @return Usuario objeto do usuário, caso encontrado
	 * @throws Exception
	 */
	public Usuario procuraUsuarioPassword(String username, String password) throws Exception;

	/**
	 * Atualiza nome do usuario
	 * 
	 * @param usuarioID
	 *            id do usuario
	 * @param nome
	 *            novo nome
	 * @throws Exception
	 */
	public void atualizarNome(Long usuarioID, String nome) throws Exception;

	/**
	 * Altera a senha do usuário
	 * 
	 * @param usuarioID
	 *            id do usuario
	 * @param passwordNew
	 *            nova senha
	 * @throws Exception
	 */
	public void alterarSenha(Long usuarioID, String passwordNew) throws Exception;

	/**
	 * Reseta a senha do usuário
	 * 
	 * @param usuarioID
	 *            id do usuario
	 * @throws Exception
	 */
	public void resetarSenha(Long usuarioID) throws Exception;

	/**
	 * Insere novo usuário
	 * 
	 * @param Usuario
	 * @throws Exception
	 */
	public long inserirUsuario(Usuario elemento) throws Exception;

	/**
	 * Procura usuário pelo username
	 * 
	 * @param username
	 * @throws Exception
	 */
	public Usuario procurarPorUsername(String username) throws Exception;

}
