/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parceiro;

/**
 *
 * @author augusto.naraujo
 */
public class Parceiro {
    private int idParceiro;
    private String CNPJ;
    private String emailParceiro;
    private String razaoParceiro;
    private String cpfParceiro;

    public int getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(int idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmailParceiro() {
        return emailParceiro;
    }

    public void setEmailParceiro(String emailParceiro) {
        this.emailParceiro = emailParceiro;
    }

    public String getRazaoParceiro() {
        return razaoParceiro;
    }

    public void setRazaoParceiro(String razaoParceiro) {
        this.razaoParceiro = razaoParceiro;
    }

    public String getCpfParceiro() {
        return cpfParceiro;
    }

    public void setCpfParceiro(String cpfParceiro) {
        this.cpfParceiro = cpfParceiro;
    }
}
