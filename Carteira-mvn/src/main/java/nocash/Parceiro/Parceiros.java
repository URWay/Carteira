package nocash.Parceiro;


import java.util.List;

public class Parceiros {

    private List<Parceiro> parceiros;

    public Parceiros(List<Parceiro> parceiros) {
        this.parceiros = parceiros;
    }
    
    public List<Parceiro> getUsuarios() {
        return parceiros;
    }
}
