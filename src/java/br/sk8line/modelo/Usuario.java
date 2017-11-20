package br.sk8line.modelo;

/*
    VErificar este exemplo https://www.devmedia.com.br/jsf-session-criando-um-modulo-de-login/30975

*/

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jboss.weld.bean.AbstractBean;

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
    
    @Column(name="IN_ADMIN_IND")
    private String AdminInd;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="DT_LAST_UPD")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;
    
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
        this.login = login;
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

    public String getAdminInd() {
        return AdminInd;
    }

    public void setAdminInd(String AdminInd) {
        this.AdminInd = AdminInd;
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

