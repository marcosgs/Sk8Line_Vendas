package br.sk8line.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jboss.weld.bean.AbstractBean;

@NamedQueries({
    @NamedQuery(name="Funcionario.consultarTodos",
            query="select f "+
                  "from Funcionario f"
    )
})

@Entity
@Table(name="TB_EMPLOYEE")
@SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ", initialValue = 1, allocationSize = 1)
public class Funcionario implements Serializable{
    
    @Id
    @Column(name="CD_EMPLOYEE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    private Long id;
    
    @Column(name="DC_EMPLOYEE", nullable = false, length = 200)
    private String nome;
    
    @Column(name="DT_HIRE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;
    
    @Column(name="DT_BIRTH_DATE", nullable = false)
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
