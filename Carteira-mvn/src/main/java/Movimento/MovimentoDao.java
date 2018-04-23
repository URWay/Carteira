/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movimento;

import java.util.List;
import daos.DaoException;
/**
 *
 * @author augusto.naraujo
 */
public interface MovimentoDao {
    
    List<Movimento> findAll() throws DaoException;
    Movimento insert(Movimento mov) throws DaoException;
    Movimento update(Movimento mov) throws DaoException;
}
