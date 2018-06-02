package br.com.urway.nocash.dao.interf;

import br.com.urway.nocash.model.Movimento;
import java.util.List;

public interface IDAOMovimento extends IDAO<Movimento> {
    
    public List<Movimento> procurarCarteira(String acao, String data) throws Exception;
    
}
