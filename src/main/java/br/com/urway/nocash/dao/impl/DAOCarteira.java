package br.com.urway.nocash.dao.impl;

import br.com.urway.nocash.dao.DAOJDBC;
import br.com.urway.nocash.dao.interf.IDAOCarteira;
import br.com.urway.nocash.model.Carteira;
import br.com.urway.nocash.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DAOCarteira extends DAOJDBC implements IDAOCarteira {

    @Override
    public List<Carteira> procurar(Object... criterios) throws Exception {
        
        List<Carteira> carteiras = new ArrayList<>();
        Cliente cliente = new Cliente();

        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " t.id, c.id as cliente, c.nome as nomeCliente, "
                            + " c.sobrenome, t.saldo, t.nome,"
                            + " FROM Carteira t"
                            + " LEFT JOIN Cliente c on t.cliente = c.id ");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    // Carteira
                    Carteira carteira = new Carteira();
                    carteira.setId(rs.getInt("id"));                    
                    carteira.setSaldo(rs.getDouble("saldo"));
                    carteira.setNome(rs.getString("nome"));
                    
                    // Cliente
                    cliente.setId(rs.getInt("cliente"));
                    cliente.setNome(rs.getString("nomeCliente"));
                    cliente.setSobrenome(rs.getString("sobrenome"));
                    
                    carteira.setCliente(cliente);
                    carteiras.add(carteira);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return carteiras;     
    }

    @Override
    public void inserir(Carteira carteira) throws Exception { 
        
        try {
            
            Cliente cliente = new Cliente();
            cliente.setId(carteira.getCliente().getId());
            
            if(cliente.getId() > 0 && cliente.getId() > 0){
                try (Connection conn = getConnection();
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO"
                                + " Carteira"
                                + " (cliente, nome,"
                                + " senha, senhaOpcional)"
                                + " VALUES (?, ?, ?, ?, ?) ")) {
                    stmt.setLong(1, cliente.getId());
                    stmt.setString(2, carteira.getNome());
                    stmt.setString(3, carteira.getSenha());
                    stmt.setShort(4, carteira.getSenhaOpcional());
                    
                    if(stmt.executeUpdate() <= 0){
                        throw new SQLException("O registro não foi inserido!");
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
    }

    @Override
    public void atualizar(Carteira carteira) throws Exception {
        
        try {
            
            Cliente cliente = new Cliente();
            cliente.setId(carteira.getCliente().getId());
            
            if(carteira.getId() > 0 && cliente.getId() > 0){
                try (Connection conn = getConnection();
                        PreparedStatement stmt = conn.prepareStatement("UPDATE "
                                + " Carteira SET"
                                + " cliente=?, nome=?, "
                                + " senha=?, senhaOpcional=?"
                                + " where id=?")) {
                    stmt.setLong(1, cliente.getId());
                    stmt.setString(2, carteira.getNome());
                    stmt.setString(3, carteira.getSenha());
                    stmt.setShort(4, carteira.getSenhaOpcional());
                    stmt.setLong(5, carteira.getId());
                    
                    if(stmt.executeUpdate() <= 0){
                        throw new SQLException("O registro não pode ser atualizado!");
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
    }

    @Override
    public void excluir(int id) throws Exception {
        
        try {
            if(id > 0){
                try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement(""
                            + "DELETE FROM Carteira where id = ? ")) {
                    stmt.setLong(1, id);
                    
                    if(stmt.executeUpdate() <= 0){
                        throw new SQLException("O registro não pode ser deletado!");
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
    }

    @Override
    public Carteira obter(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
