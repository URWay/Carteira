/**
 * Classes de objetos de acesso a dados
 */
package br.com.urway.nocash.dao.impl;

import br.com.urway.nocash.dao.DAOJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.urway.nocash.dao.interf.IDAOUsuario;
import br.com.urway.nocash.model.Cargo;
import br.com.urway.nocash.model.Usuario;
import java.sql.Date;

/**
 * DAO de usuário
 * 
 * @see IDAO
 */
public class DAOUsuario extends DAOJDBC implements IDAOUsuario {

    @Override
    public void atualizarNome(int usuarioID, String nome) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarSenha(int usuarioID, String passwordNew) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetarSenha(int usuarioID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long inserirUsuario(Usuario elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario procurarPorUsername(String username) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> procurar(Object... criterios) throws Exception {
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT "
                    + " u.id usuarioID, u.nome usuarioNOME, u.email, u.senha, "
                    + " c.id cargoID, c.nome cargoNOME "
                    + " FROM Usuario u "
                    + " LEFT JOIN Cargo c on u.cargo = c.id "
                    + " ORDER BY usuarioNOME");
                    ResultSet rs = stmt.executeQuery()) {
            	System.out.println("teste");
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("usuarioID"));
                    usuario.setNome(rs.getString("usuarioNOME"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    Cargo cargo = new Cargo();
                    cargo.setId(rs.getInt("cargoID"));
                    cargo.setNome(rs.getString("cargoNOME"));
                    usuario.setCargo(cargo);
                     
                    usuarios.add(usuario);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return usuarios;
    }

    @Override
    public void inserir(Usuario elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Usuario elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obter(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
