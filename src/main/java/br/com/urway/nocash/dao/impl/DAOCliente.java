package br.com.urway.nocash.dao.impl;

import br.com.urway.nocash.dao.DAOJDBC;
import br.com.urway.nocash.dao.interf.IDAOCliente;
import br.com.urway.nocash.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente extends DAOJDBC implements IDAOCliente {

    @Override
    public List<Cliente> procurar(Object... criterios) throws Exception {
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " c.id, c.nome, c.sobrenome, c.email, c.cep,"
                            + " c.cpf, c.rg, c.dtNasc, c.sexo, c.tel, c.cel,"
                            + " c.dtRegistro, c.senha "
                            + " FROM Cliente c"
                            + " ORDER BY nome");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setTel(rs.getString("tel"));
                    cliente.setCel(rs.getString("cel"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setSobrenome(rs.getString("sobrenome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setCep(rs.getString("cep"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setRg(rs.getString("rg"));
                    cliente.setSexo(rs.getString("sexo"));
                    
                    //cliente.setDtNasc(rs.getDate("dtNasc"));
                    //cliente.setDtRegistro(rs.getDate("dtRegistro"));
                    
                    cliente.setSenha(rs.getString("senha"));
                    
                    clientes.add(cliente);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }

    @Override
    public void inserir(Cliente cliente) throws Exception {

        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO"
                            + " Cliente"
                            + " (nome, sobrenome, email, cep,"
                            + " cpf, rg, sexo, tel, cel, senha) "
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")) {

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getSobrenome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getCpf());
                stmt.setString(6, cliente.getRg());
                stmt.setString(7, cliente.getSexo());
                stmt.setString(8, cliente.getTel());
                stmt.setString(9, cliente.getCel());
                stmt.setString(10, cliente.getSenha());
                
                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("UPDATE cliente SET"
                        + " nome =  ?,"
                        + " sobrenome = ?, "
                        + " email = ?, "
                        + " cep = ?, "
                        + " cpf = ?, "
                        + " rg = ?, "
                        + " sexo = ?, "
                        + " tel = ?, "
                        + " cel = ? "
                        + " WHERE id = ?")) {

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getSobrenome());
                stmt.setString(3, cliente.getEmail()); 
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getCpf());
                stmt.setString(6, cliente.getRg());
                stmt.setString(7, cliente.getSexo());
                stmt.setString(8, cliente.getTel());
                stmt.setString(9, cliente.getCel());
                stmt.setInt(10, cliente.getId());
                
                if(stmt.executeUpdate() <= 0){
                    throw new SQLException("O registro não pode ser atualizado!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }
    }

    @Override
    public void excluir(int id) throws Exception {
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("DELETE FROM Cliente c"
                            + " WHERE c.id = ?")) {
                
                stmt.setInt(1, id);
                
                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (!rs.next()) {
                            throw new SQLException("Cliente não foi excluído!");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }
    }

    @Override
    public Cliente obter(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Cliente Login(Cliente cliente) throws Exception {
        
        Cliente retornoCliente = new Cliente();
        
        try {
            
            try (Connection conn = getConnection()) {
                    PreparedStatement stmt = 
                            conn.prepareStatement("select top(1) * from Cliente where email = ? AND senha = ?");
                    stmt.setString(1, cliente.getEmail());
                    stmt.setString(2, cliente.getSenha());
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        retornoCliente.setId(rs.getInt("id"));
                        retornoCliente.setNome(rs.getString("nome").trim());
                        retornoCliente.setEmail(rs.getString("email").trim());
                        retornoCliente.setSobrenome(rs.getString("sobrenome").trim());
                        retornoCliente.setCep(rs.getString("cep").trim());
                        retornoCliente.setCpf(rs.getString("cpf").trim());
                        retornoCliente.setRg(rs.getString("rg").trim());
                        //retornoCliente.setDtNasc(rs.getDate("dtNasc"));
                        retornoCliente.setSexo(rs.getString("sexo"));
                        retornoCliente.setCel(rs.getString("tel"));
                        retornoCliente.setCel(rs.getString("cel"));
                        //retornoCliente.setDtRegistro(rs.getDate("dtRegistro"));
                    }
            }
        } catch(SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex);
        }
        
        return retornoCliente;
    }
    
}
