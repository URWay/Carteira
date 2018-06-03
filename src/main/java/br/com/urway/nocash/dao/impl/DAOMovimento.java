/**
 * Classes de objetos de acesso a dados
 */
package br.com.urway.nocash.dao.impl;

import br.com.urway.nocash.dao.DAOJDBC;
import br.com.urway.nocash.dao.interf.IDAOMovimento;
import br.com.urway.nocash.model.Cliente;
import br.com.urway.nocash.model.Carteira;
import br.com.urway.nocash.model.Movimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class DAOMovimento extends DAOJDBC implements IDAOMovimento {

    @Override
    public List<Movimento> procurar(Object... criterios) throws Exception{
        
         List<Movimento> mov = new ArrayList<>();
         
         try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " m.id, m.carteiraOrigem, m.carteiraDestino, m.nrDocumento, m.vlBRUTO, m.vlLiquido, m.vlDesc, m.dtMovimento,"
                            + " o.id as 'idOrigem', o.saldo as 'saldoOrigem', o.nome as 'nomeOrigem',"
                            + " d.id as 'idDestino', d.saldo as 'saldoDestino', d.nome as 'nomeDestino'"
                            + " FROM Movimento m"
                            + " LEFT JOIN Carteira o ON o.id = m.carteiraOrigem"
                            + " LEFT JOIN Carteira d on d.id = m.carteiraOrigem"
                            + " ORDER BY dtMovimento");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    
                    Movimento movimento = new Movimento();
                    movimento.setId(rs.getInt("id"));
                    movimento.setCarteiraOrigem(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idOrigem"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoOrigem"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeOrigem"));
                        
                    movimento.setCarteiraDestino(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idDestino"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoDestino"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeDestino"));
                   
                    movimento.setNrDocumento(rs.getString("nrDocumento"));
                    movimento.setVlBruto(rs.getDouble("vlBRUTO"));
                    movimento.setVlLiquido(rs.getDouble("vlLIQUIDO"));
                    movimento.setVlDesc(rs.getDouble("vlDESC"));
                    movimento.setDtMovimento(rs.getTimestamp("dtMovimento"));
                    mov.add(movimento);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return mov;
    }
    
    @Override
    public void inserir(Movimento mov) throws Exception {

        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO"
                            + " Movimento"
                            + " (carteiraOrigem, carteiraDestino, acao, nrDocumento, vlBruto, vlLiquido, lvDesc, dtMovimento)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ")) {

                stmt.setInt(1, mov.getCarteiraOrigem().getId());
                stmt.setInt(2, mov.getCarteiraDestino().getId());
                stmt.setString(4, mov.getNrDocumento());
                stmt.setDouble(5, mov.getVlBruto());
                stmt.setDouble(6, mov.getVlLiquido());
                stmt.setDouble(7, mov.getVlDesc());
                stmt.setTimestamp(8, mov.getDtMovimento());
                
                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (!rs.next()) {
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
    public void atualizar(Movimento elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movimento obter(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimento> procurarCarteira(String acao, String data) throws Exception {
        List<Movimento> mov = new ArrayList<>();
         
         try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " m.carteiraOrigem, m.carteiraDestino, m.nrDocumento, m.vlBRUTO, m.vlLiquido, m.vlDesc, m.dtMovimento,"
                            + " o.id as 'idOrigem', o.saldo as 'saldoOrigem', o.nome as 'nomeOrigem',"
                            + " d.id as 'idDestino', d.saldo as 'saldoDestino', d.nome as 'nomeDestino'"
                            + " FROM Movimento m"
                            + " LEFT JOIN Carteira o ON o.id = m.carteiraOrigem"
                            + " LEFT JOIN Carteira d on d.id = m.carteiraOrigem"
                            + " ORDER BY dtMovimento");
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    
                    Movimento movimento = new Movimento();
                    movimento.setId(rs.getInt("id"));
                    movimento.setCarteiraOrigem(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idOrigem"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoOrigem"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeOrigem"));
                        
                    movimento.setCarteiraDestino(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idDestino"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoDestino"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeDestino"));
                   
                    movimento.setNrDocumento(rs.getString("nrDocumento"));
                    movimento.setVlBruto(rs.getDouble("vlBRUTO"));
                    movimento.setVlLiquido(rs.getDouble("vlLIQUIDO"));
                    movimento.setVlDesc(rs.getDouble("vlDESC"));
                    movimento.setDtMovimento(rs.getTimestamp("dtMovimento"));
                    mov.add(movimento);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return mov;
    }
    
    @Override
    public void cargaCarteira(Movimento mov) throws Exception {

        try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO"
                            + " Movimento"
                            + " (carteiraOrigem, carteiraDestino, acao, nrDocumento, vlBruto, vlLiquido, lvDesc, dtMovimento)"
                            + " VALUES (0, ?, ?, ?, ?, ?, ?, ?) ")) {

                stmt.setInt(2, mov.getCarteiraDestino().getId());
                stmt.setString(4, mov.getNrDocumento());
                stmt.setDouble(5, mov.getVlBruto());
                stmt.setDouble(6, mov.getVlLiquido());
                stmt.setDouble(7, mov.getVlDesc());
                stmt.setTimestamp(8, mov.getDtMovimento());
                
                if (stmt.executeUpdate() == 0) {
                    throw new SQLException("Nenhum registro inserido!");
                } else {
                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (!rs.next()) {
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
    public List<Movimento> getDestino(int id) throws Exception{
        
         List<Movimento> mov = new ArrayList<>();
         
         try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " m.id, m.carteiraOrigem, m.carteiraDestino, m.nrDocumento, m.vlBRUTO, m.vlLiquido, m.vlDesc, m.dtMovimento,"
                            + " o.id as 'idOrigem', o.saldo as 'saldoOrigem', o.nome as 'nomeOrigem',"
                            + " d.id as 'idDestino', d.saldo as 'saldoDestino', d.nome as 'nomeDestino'"
                            + " FROM Movimento m"
                            + " LEFT JOIN Carteira o ON o.id = m.carteiraOrigem"
                            + " LEFT JOIN Carteira d on d.id = m.carteiraOrigem"
                            + " WHERE m.carteiraDestino = ?"
                            + " ORDER BY dtMovimento")){
                    stmt.setInt(1,id);
                    
            
                    ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    
                    
                    Movimento movimento = new Movimento();
                    movimento.setId(rs.getInt("id"));
                    movimento.setCarteiraOrigem(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idOrigem"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoOrigem"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeOrigem"));
                        
                    movimento.setCarteiraDestino(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idDestino"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoDestino"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeDestino"));
                   
                    movimento.setNrDocumento(rs.getString("nrDocumento"));
                    movimento.setVlBruto(rs.getDouble("vlBRUTO"));
                    movimento.setVlLiquido(rs.getDouble("vlLIQUIDO"));
                    movimento.setVlDesc(rs.getDouble("vlDESC"));
                    movimento.setDtMovimento(rs.getTimestamp("dtMovimento"));
                    mov.add(movimento);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return mov;
    }
    
    @Override
    public List<Movimento> getOrigem(int id) throws Exception{
        
         List<Movimento> mov = new ArrayList<>();
         
         try {
            try (Connection conn = getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT"
                            + " m.id, m.carteiraOrigem, m.carteiraDestino, m.nrDocumento, m.vlBRUTO, m.vlLiquido, m.vlDesc, m.dtMovimento,"
                            + " o.id as 'idOrigem', o.saldo as 'saldoOrigem', o.nome as 'nomeOrigem',"
                            + " d.id as 'idDestino', d.saldo as 'saldoDestino', d.nome as 'nomeDestino'"
                            + " FROM Movimento m"
                            + " LEFT JOIN Carteira o ON o.id = m.carteiraOrigem"
                            + " LEFT JOIN Carteira d on d.id = m.carteiraOrigem"
                            + " WHERE m.carteiraOrigem = ?"
                            + " ORDER BY dtMovimento")){
                    stmt.setInt(1,id);
                    
            
                    ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    
                    
                    Movimento movimento = new Movimento();
                    movimento.setId(rs.getInt("id"));
                    movimento.setCarteiraOrigem(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idOrigem"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoOrigem"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeOrigem"));
                        
                    movimento.setCarteiraDestino(new Carteira());
                        movimento.getCarteiraOrigem().setId(rs.getInt("idDestino"));
                        movimento.getCarteiraOrigem().setSaldo(rs.getDouble("saldoDestino"));
                        movimento.getCarteiraOrigem().setNome(rs.getString("nomeDestino"));
                   
                    movimento.setNrDocumento(rs.getString("nrDocumento"));
                    movimento.setVlBruto(rs.getDouble("vlBRUTO"));
                    movimento.setVlLiquido(rs.getDouble("vlLIQUIDO"));
                    movimento.setVlDesc(rs.getDouble("vlDESC"));
                    movimento.setDtMovimento(rs.getTimestamp("dtMovimento"));
                    mov.add(movimento);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception(ex);
        }
        
        return mov;
    }
}

