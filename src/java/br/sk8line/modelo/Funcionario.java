package br.sk8line.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPLOYEE")
@SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ", initialValue = 1, allocationSize = 1)
public class Funcionario implements Serializable{
    
    @Id
    @Column(name="CD_EMPLOYEE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    private Long id;
    
    @Column(name="DC_EMPLOYEE")
    private String nome;
    
    @Column(name="DT_HIRE")
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;
    
    @Column(name="DT_BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @OneToOne(mappedBy = "Funcionario", optional = true )
    private Usuario usuario;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
