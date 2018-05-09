package nocash.Carteira;

public class Carteira {
    private int idCarteira;
    private int fkCliente;
    private int saldo;
    private String nomeCarteira;
    private String canal;
    private String senha;
    private short senhaOpcional;

    public int getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setNomeCarteira(String nomeCarteira) {
        this.nomeCarteira = nomeCarteira;
    }

	public short getSenhaOpcional() {
		return senhaOpcional;
	}

	public void setSenhaOpcional(short senhaOpcional) {
		this.senhaOpcional = senhaOpcional;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
}
