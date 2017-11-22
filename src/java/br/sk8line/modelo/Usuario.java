package br.sk8line.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;
import org.jboss.weld.bean.AbstractBean;

@NamedQueries({
  @NamedQuery(name = "Usuario.consultarTodos",
              query= "SELECT u FROM Usuario u" +
                      " WHERE u.nome <> 'admin'"),
    
  @NamedQuery(name = "Usuario.login",
              query = " SELECT u " +
                      " FROM Usuario u" +
                      " WHERE u.login = :login ")
})

@Entity
@Table(name="TB_USERS")
@SequenceGenerator(name="usuarioSeq",sequenceName="USERS_SEQ",initialValue = 1, allocationSize = 1 )
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSeq")
    @Column(name="CD_USER", nullable = false)
    private Long id;

    @Column(name="DC_NAME_USER", nullable=false, unique = true, length = 200)
    private String login;
    
    @Column(name="DC_PASSWORD", nullable=false, length = 500)
    private String senha;
    
    @Column(name="DC_NAME", nullable=false)
    private String nome;
    
    @Column(name="IN_ADMIN", nullable=false)
    private String indAdmin;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="DT_LAST_UPD")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;
    
    @OneToOne
    @JoinColumn (name="CD_CLIENT")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn (name="CD_EMPLOYEE")
    private Funcionario funcionario;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login.trim().toLowerCase();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndAdmin() {
        return indAdmin;
    }

    public void setIndAdmin(String indAdmin) {
        this.indAdmin = indAdmin;
    }
    
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                 return true;
        if (obj == null)
                 return false;
        if (getClass() != obj.getClass())
                 return false;

        return (obj instanceof AbstractBean) ? (this.getId() == null ? this == obj : this.getId().equals(((AbstractBean)obj).getId())):false;
    }
}

