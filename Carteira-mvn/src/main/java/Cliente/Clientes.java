package Cliente;

import usuarios.*;
import java.util.List;

public class Clientes {

    private List<Usuario> usuarios;

    public Clientes(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
