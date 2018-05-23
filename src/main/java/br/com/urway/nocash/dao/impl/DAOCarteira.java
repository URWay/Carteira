/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author jefferson
 */
public class DAOCarteira extends DAOJDBC implements IDAOCarteira {

    @Override
    public List<Carteira> procurar(Object... criterios) throws Exception {
        
        List<Carteira> carteiras = new ArrayList<>();
        
        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " t.id, c.id as cliente, c.nome, c.sobrenome, t.saldo, t.nome,"
                            + " t.canal "
                            + " FROM Carteira t"
                            + " LEFT JOIN Cliente c on t.id = c.id ");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    // Carteira
                    Carteira carteira = new Carteira();
                    carteira.setId(rs.getInt("t.id"));
                    carteira.setSaldo(rs.getDouble("t.saldo"));
                    carteira.setNome(rs.getString("t.nome"));
                    carteira.setCanal(rs.getString("t.canal"));
                    
                    // Cliente
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("c.id"));
                    cliente.setNome(rs.getString("c.nome"));
                    cliente.setSobrenome(rs.getString("c.sobrenome"));
                    
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
            
            if(cliente.getId() > 0){
                try (Connection conn = getConnection();
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO"
                                + " Carteira"
                                + " (fkcliente, saldo, nome, canal,"
                                + " senha, senhaOpcional)"
                                + " VALUES (?, ?, ?, ?, ?, ?) ")) {
                    stmt.setLong(1, cliente.getId());
                    stmt.setDouble(2, carteira.getSaldo());
                    stmt.setString(3, carteira.getNome());
                    stmt.setString(4, carteira.getCanal());
                    stmt.setString(5, carteira.getSenha());
                    stmt.setShort(6, carteira.getSenhaOpcional());
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
    }

    @Override
    public void atualizar(Carteira elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carteira obter(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
