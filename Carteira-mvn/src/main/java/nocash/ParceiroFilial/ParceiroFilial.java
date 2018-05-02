package nocash.ParceiroFilial;

public class ParceiroFilial {
    private int idFilial;
    private int fkParceiro;
    private double desconto;

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public int getFkParceiro() {
        return fkParceiro;
    }

    public void setFkParceiro(int fkParceiro) {
        this.fkParceiro = fkParceiro;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
