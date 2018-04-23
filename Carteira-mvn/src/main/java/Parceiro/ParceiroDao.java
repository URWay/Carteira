/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parceiro;
import daos.DaoException;
import java.util.List;

/**
 *
 * @author augusto.naraujo
 */
public interface ParceiroDao {
    
    List<Parceiro> findAll() throws DaoException;
    Parceiro insert(Parceiro par) throws DaoException;
    Parceiro update(Parceiro par) throws DaoException;
}
