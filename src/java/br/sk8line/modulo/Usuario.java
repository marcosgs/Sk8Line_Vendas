package br.sk8line.modulo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;

@Entity
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
    
}

