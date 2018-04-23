package ParceiroFilial;




import Carteira.*;
import java.util.List;

public class ParceirosFilial {

    private List<ParceiroFilial> parceirosfilial;

    public ParceirosFilial(List<ParceiroFilial> parceirosfilial) {
        this.parceirosfilial = parceirosfilial;
    }
    
    public List<ParceiroFilial> getUsuarios() {
        return parceirosfilial;
    }
}
