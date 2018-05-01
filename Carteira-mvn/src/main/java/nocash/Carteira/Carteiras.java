package nocash.Carteira;




import java.util.List;

public class Carteiras {

    private List<Carteira> carteiras;

    public Carteiras(List<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
    
    public List<Carteira> getUsuarios() {
        return carteiras;
    }
}
