/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            throw new Exception(ex);
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
                            + " cpf, rg, dtNasc, sexo, tel, cel,"
                            + " dtRegistro, senha) "
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")) {

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getSobrenome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getCpf());
                stmt.setString(6, cliente.getRg());
                stmt.setDate(7, cliente.getDtNasc());
                stmt.setString(8, cliente.getSexo());
                stmt.setString(9, cliente.getTel());
                stmt.setString(10, cliente.getCel());
                stmt.setDate(11, cliente.getDtRegistro());
                stmt.setString(12, cliente.getSenha());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void atualizar(Cliente elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente obter(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
