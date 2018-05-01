package nocash.Movimento;



import java.util.List;

public class Movimentos {

    private List<Movimento> movimentos;

    public Movimentos(List<Movimento> parceiros) {
        this.movimentos = parceiros;
    }
    
    public List<Movimento> getUsuarios() {
        return movimentos;
    }
}
