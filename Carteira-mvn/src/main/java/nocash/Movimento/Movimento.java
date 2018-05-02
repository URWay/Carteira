package nocash.Movimento;

import java.sql.Timestamp;

public class Movimento {
    private int idMovimento;
    private int fkCarConta;
    private int fkCarDestino;
    private String acaoMov;
    private String nrDocumento;
    private double vlBruto;
    private double vlLiquido;
    private double vlDesc;
    private Timestamp dtMovimento;

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public int getFkCarConta() {
        return fkCarConta;
    }

    public void setFkCarConta(int fkCarConta) {
        this.fkCarConta = fkCarConta;
    }

    public int getFkCarDestino() {
        return fkCarDestino;
    }

    public void setFkCarDestino(int fkCarDestino) {
        this.fkCarDestino = fkCarDestino;
    }

    public String getAcaoMov() {
        return acaoMov;
    }

    public void setAcaoMov(String acaoMov) {
        this.acaoMov = acaoMov;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(String nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    public double getVlBruto() {
        return vlBruto;
    }

    public void setVlBruto(double vlBruto) {
        this.vlBruto = vlBruto;
    }

    public double getVlLiquido() {
        return vlLiquido;
    }

    public void setVlLiquido(double vlLiquido) {
        this.vlLiquido = vlLiquido;
    }

    public double getVlDesc() {
        return vlDesc;
    }

    public void setVlDesc(double vlDesc) {
        this.vlDesc = vlDesc;
    }

    public Timestamp getDtMovimento() {
        return dtMovimento;
    }

    public void setDtMovimento(Timestamp dtMovimento) {
        this.dtMovimento = dtMovimento;
    }
}
