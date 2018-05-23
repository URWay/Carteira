/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urway.nocash.dao.interf;

import br.com.urway.nocash.model.Cliente;
import java.util.List;

public interface IDAOCliente extends IDAO<Cliente> {

    public Cliente Login(Cliente cliente) throws Exception;

}
