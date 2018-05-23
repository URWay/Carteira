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
                
                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            int id = rs.getInt("idCliente");
                            cliente.setId(id);
                        } else {
                            throw new SQLException("Id não foi criado!");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
                
        
        //    String dtRegistroS = object.getString("dtRegistro");
        //    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //    java.sql.Date data = (java.sql.Date) sdf.parse(dtRegistroS);
        //    Date dtRegistro = new Date(data.getTime());
        //    data = (java.sql.Date) sdf.parse(dtNascS);
        //   Date dtNasc = new Date(data.getTime());
        
        //if(cliente.isValid("A")){
        //    throw new IllegalArgumentException("cliente");
        //}
        
        try {
            Connection conn = getConnection(); 

            String sql = "UPDATE cliente SET"
               + "nome =  ?,"
               + "sobrenome = ?, "
               + "email = ?, "
               + "cep = ?, "
               + "cpf = ?, "
               + "rg = ?, "
               + "dtNasc = ?, "
               + "sexo = ?, "
               + "tel = ?, "
               + "cel = ?, "
               + "dtRegistro = ?   "
               + "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobrenome());
            ps.setString(3, cliente.getEmail()); 
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getCpf());
            ps.setString(6, cliente.getRg());
            ps.setDate(7, cliente.getDtNasc());
            ps.setString(8, cliente.getSexo());
            ps.setString(9, cliente.getTel());
            ps.setString(10, cliente.getCel());
            ps.setDate(11, cliente.getDtRegistro());
            ps.setInt(12, cliente.getId());

            if(ps.executeUpdate() <= 0){
                throw new SQLException("O registro não pode ser atualizado!");
            }

        } catch(ClassNotFoundException | SQLException ex){
            throw new Exception(ex);
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
                        if (rs.next()) {
                        } else {
                            throw new SQLException("Cliente não foi excluído!");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
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
                    PreparedStatement stmt = conn.prepareStatement("select top(1) * from Cliente where email = ? AND senha = ?");
                    stmt.setString(1, cliente.getEmail());
                    stmt.setString(2, cliente.getSenha());
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        retornoCliente.setId(rs.getInt("id"));
                        retornoCliente.setNome(rs.getString("nome"));
                        retornoCliente.setSobrenome(rs.getString("sobrenome"));
                        retornoCliente.setCep(rs.getString("cep"));
                        retornoCliente.setCpf(rs.getString("cpf"));
                        retornoCliente.setRg(rs.getString("rg"));
                        retornoCliente.setDtNasc(rs.getDate("dtNasc"));
                        retornoCliente.setSexo(rs.getString("sexo"));
                        retornoCliente.setCel(rs.getString("tel"));
                        retornoCliente.setCel(rs.getString("cel"));
                        retornoCliente.setDtRegistro(rs.getDate("dtRegistro"));

                    }
            }
        } catch(SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retornoCliente;
    }
    
}
