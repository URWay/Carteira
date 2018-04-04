/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Senha;

/**
 *
 * @author augusto.naraujo
 */
public class Senha {
    private int idSenha;
    private int fkCarteira;
    private String canal;
    private String senha1;
    private byte senhaopcional;

    public int getIdSenha() {
        return idSenha;
    }

    public void setIdSenha(int idSenha) {
        this.idSenha = idSenha;
    }

    public int getFkCarteira() {
        return fkCarteira;
    }

    public void setFkCarteira(int fkCarteira) {
        this.fkCarteira = fkCarteira;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getSenha1() {
        return senha1;
    }

    public void setSenha1(String senha1) {
        this.senha1 = senha1;
    }

    public byte getSenhaopcional() {
        return senhaopcional;
    }

    public void setSenhaopcional(byte senhaopcional) {
        this.senhaopcional = senhaopcional;
    }
}
