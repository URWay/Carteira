package nocash.Cliente;

import java.sql.Timestamp;
import java.util.Date;
import validacoes.valid;

public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String sobreCliente;
    private String emailCliente;
    private String cepCliente;
    private String cpfCliente;
    private String rgCliente;
    private Timestamp dtNasc;
    private String sexo;
    private int telCliente;
    private int celCliente;
    private Timestamp dtRegistro;
    public String senha;
    public String data;
    
    public Cliente(int idCliente, String nomeCliente, String sobreCliente, String emailCliente, String cepCliente, String cpfCliente, String rgCliente, Timestamp dtNasc, String sexo, int telCliente, int celCliente, Timestamp dtRegistro, String senha, String data) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.sobreCliente = sobreCliente;
        this.emailCliente = emailCliente;
        this.cepCliente = cepCliente;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.telCliente = telCliente;
        this.celCliente = celCliente;
        this.dtRegistro = dtRegistro;
        this.senha = senha;
        this.data = data;
    }
        
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobreCliente() {
        return sobreCliente;
    }

    public void setSobreCliente(String sobreCliente) {
        this.sobreCliente = sobreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Timestamp dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(int telCliente) {
        this.telCliente = telCliente;
    }

    public int getCelCliente() {
        return celCliente;
    }

    public void setCelCliente(int celCliente) {
        this.celCliente = celCliente;
    }

    public Date getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(Timestamp dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    // Valida o cliente
    public boolean isValid(String acao) {
        boolean retorno = true;
        if(nomeCliente != null && !nomeCliente.trim().isEmpty()){
            retorno = false;
        } else if(emailCliente != null && emailCliente.trim().isEmpty() || 
                valid.isEmail(emailCliente) || valid.isUniqueEmail(emailCliente)){
            retorno = false;
        } else if(sexo != null && sexo.trim().isEmpty()){
            retorno = false;
        } else if(cpfCliente != null && cpfCliente.trim().isEmpty()){
            retorno = false;
        } else if(acao.equals("I")){
            if(senha != null && senha.trim().isEmpty() ){
                retorno = false;
            }
        } else if(cepCliente != null && cepCliente.trim().isEmpty()){
            retorno = false;
        }

        return retorno;
    }
}
