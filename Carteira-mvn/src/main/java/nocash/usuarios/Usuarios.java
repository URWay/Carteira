package nocash.usuarios;

import java.util.List;

public class Usuarios {

    private List<Usuario> usuarios;

    public Usuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
