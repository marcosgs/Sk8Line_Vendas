package br.sk8line.modulo;

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

@NamedQueries({
  @NamedQuery(name = "Usuario.consultarTodos",
              query= "SELECT u FROM Usuario u"),
    
  @NamedQuery(name = "Usuario.login",
              query = " SELECT u " +
                      " FROM Usuario u" +
                      " WHERE u.login = :login " +
                      " and u.nome <> 'root'")
})

@Entity
@Table(name="TB_USERS")
@SequenceGenerator(name="USERS_SEQ",sequenceName="USERS_SEQ",initialValue=1, allocationSize=1)
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name="CD_USER")
    private Long id;

    @Column(name="DC_NAME_USER",nullable=false)
    private String login;
    
    @Column(name="DC_PASSWORD",nullable=false)
    private String senha;
    
    @Column(name="DC_NAME",nullable=false)
    private String nome;
    
    @Column(name="IN_ADMIN_IND")
    private String AdminInd;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date data_Atual;
    
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

    public Date getData_Atual() {
        return data_Atual;
    }

    public void setData_Atual(Date data_Atual) {
        this.data_Atual = data_Atual;
    }
    
    
}

