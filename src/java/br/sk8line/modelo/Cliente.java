package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name="Cliente.consultarTodos",
            query="select c "+
                  "from Cliente c"
    )
})

@Entity
@Table(name="TB_CLIENTS")
@SequenceGenerator(name="CLIENT_SEQ", sequenceName = "CLIENT_SEQ", initialValue = 1 , allocationSize = 1)
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CLIENT_SEQ")
    @Column(name="CD_CLIENT")
    private Long id;
    
    @Column(name="DC_CLIENT",nullable = false,length = 200)
    private String nome;

    @Column(name="IN_TYPE_CLIENT")
    private String tipoCliente;
    
    @Column(name="DC_CPF_CNPJ", nullable = false)
    private String numeroCNPJCPF;
    
    @Column(name="DT_BIRTH_DATE", nullable=false)
    private Date dataNascimento;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="DT_LAST_UPD")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;
    
    @OneToOne(mappedBy = "Cliente", optional = true )
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNumeroCNPJCPF() {
        return numeroCNPJCPF;
    }

    public void setNumeroCNPJCPF(String numeroCNPJCPF) {
        this.numeroCNPJCPF = numeroCNPJCPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    
    
    
}
