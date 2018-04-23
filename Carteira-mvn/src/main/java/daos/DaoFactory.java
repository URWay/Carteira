package daos;

import usuarios.UsuarioDao;
import usuarios.UsuarioDaoJdbc;

import Cliente.ClienteDao;
import Cliente.ClienteDaoJdbc;

public class DaoFactory {
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://carteiravirtual-ws-pi.database.windows.net;database=carteiravirtual";
    private static final String USER = "CarteiraVirtualAdmin";
    private static final String PASS = "CarteiraVirtual@PIV";

    public static UsuarioDao getCategoriaDao() {
        return new UsuarioDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static ClienteDao getClienteDao() {
        return new ClienteDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static ParceiroDao getParceiroeDao() {
        return new ParceiroDaoJdbc(DRIVER, URL, USER, PASS);
    }
        
    public static ParceirosFilialDao getParceirosFilialDao() {
        return new ParceirosFilialDaoJdbc(DRIVER, URL, USER, PASS);
    }
    
    public static CarteiraDao getCarteiraDao() {
        return new CarteiraDaoJdbc(DRIVER, URL, USER, PASS);
    }

    public static MovimentoDao getMovimentoDao() {
        return new MovimentoDaoJdbc(DRIVER, URL, USER, PASS);
    }
}