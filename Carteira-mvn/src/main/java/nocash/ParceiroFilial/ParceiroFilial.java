/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nocash.ParceiroFilial;

/**
 *
 * @author augusto.naraujo
 */
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
