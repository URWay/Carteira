package nocash.daos;

import nocash.usuarios.UsuarioDao;
import nocash.usuarios.UsuarioDaoJdbc;

import nocash.Cliente.ClienteDao;
import nocash.Cliente.ClienteDaoJdbc;

import nocash.Parceiro.ParceiroDao;
import nocash.Parceiro.ParceiroDaoJdbc;

import validacoes.valid;

public class DaoFactory {
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://carteiravirtual-ws-pi.database.windows.net:1433;database=carteiravirtual";
    private static final String USER = "CarteiraVirtualAdmin@carteiravirtual-ws-pi";
    private static final String PASS = "CarteiraVirtual@PIV";

    public static UsuarioDao getCategoriaDao() {
        return new UsuarioDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static ClienteDao getClienteDao() {
        return new ClienteDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static ParceiroDao getParceiroDao() {
        return new ParceiroDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    /*  
    public static ParceirosFilialDao getParceirosFilialDao() {
        return new ParceirosFilialDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static CarteiraDao getCarteiraDao() {
        return new CarteiraDaoJdbc(DRIVER, URL, USER, PASS);
    }

    public static MovimentoDao getMovimentoDao() {
        return new MovimentoDaoJdbc(DRIVER, URL, USER, PASS);
    }
	*/
    public static valid getConn() {
        return new valid(DRIVER, URL, USER, PASS);
    }
}