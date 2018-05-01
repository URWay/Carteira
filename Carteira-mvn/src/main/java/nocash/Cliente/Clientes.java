package nocash.Cliente;

import java.util.List;

public class Clientes {

    private List<Cliente> clientes;

    public Clientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public List<Cliente> getUsuarios() {
        return clientes;
    }
}
