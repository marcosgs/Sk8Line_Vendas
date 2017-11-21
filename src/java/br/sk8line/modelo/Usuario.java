package br.sk8line.modelo;

/*
    Verificar este exemplo https://www.devmedia.com.br/jsf-session-criando-um-modulo-de-login/30975

*/

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
import org.jboss.weld.bean.AbstractBean;
import javax.persistence.OneToOne;

@NamedQueries({
  @NamedQuery(name = "Usuario.consultarTodos",
              query= "SELECT u FROM Usuario u" +
                      " WHERE u.nome <> 'root'"),
    
  @NamedQuery(name = "Usuario.login",
              query = " SELECT u " +
                      " FROM Usuario u" +
                      " WHERE u.login = :login ")
})

@Entity
@Table(name="TB_USERS")
@SequenceGenerator(name="USERS_SEQ",sequenceName="USERS_SEQ",initialValue = 1, allocationSize = 1 )
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name="CD_USER")
    private Long id;

    @Column(name="DC_NAME_USER", nullable=false, unique = true, length = 200)
    private String login;
    
    @Column(name="DC_PASSWORD",nullable=false)
    private String senha;
    
    @Column(name="DC_NAME",nullable=false)
    private String nome;
    
    @Column(name="IN_TYPE_USER")
    private String indTipo;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="DT_LAST_UPD")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;
    
    @OneToOne
    @JoinColumn (name="CD_CLIENT")
    private Cliente cliente;
    
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

    public String getIndTipo() {
        return indTipo;
    }

    public void setIndTipo(String indTipo) {
        this.indTipo = indTipo;
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
}

