package usuarios;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String fkpermissoes;
    private int fkConfiguracoes;

    public Usuario(int idUsuario, String nome, String email, String senha, String fkpermissoes, int fkConfiguracoes) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.fkpermissoes = fkpermissoes;
        this.fkConfiguracoes = fkConfiguracoes;
    }
    
    public int getIdusuario()
    {
            return this.idUsuario;
    }

    public void setIdusuario(int idUsuario)
    {
            this.idUsuario = idUsuario;
    }

    public String getNome()
    {
            return this.nome;
    }

    public void setNome(String nome)
    {
            this.nome = nome;
    }

    public String getEmail()
    {
            return this.email;
    }

    public void setEmail(String email)
    {
            this.email = email;
    }

    public String getSenha()
    {
            return this.senha;
    }

    public void setSenha(String senha)
    {
            this.senha = senha;
    }

    public String getFkpermissoes()
    {
            return this.fkpermissoes;
    }

    public void setFkpermissoes(String fkpermissoes)
    {
            this.fkpermissoes = fkpermissoes;
    }

    public int getFkconfiguracoes()
    {
            return this.fkConfiguracoes;
    }

    public void setFkconfiguracoes(int fkConfiguracoes)
    {
            this.fkConfiguracoes = fkConfiguracoes;
    }

}
