
package br.sk8line.modelo;

import java.util.List;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name="TB_UF")
@SequenceGenerator(name="UF_SEQ", sequenceName="UF_SEQ", initialValue=1, allocationSize=1)
public class UF implements Serializable {
    
    @Id
    @Column(name="CD_UF")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "UF_SEQ")
    private Long id;
    
    @Column(name="CD_ABREV_UF", nullable=false, length = 2)
    private String sigla;
    
    @Column(name="DC_UF", nullable =false, length = 200)
    private String descricao;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="CD_UF")
    private List<Cidade> cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }   
}
