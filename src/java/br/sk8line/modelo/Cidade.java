package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CITY")
@SequenceGenerator(name= "CITY_SEQ", sequenceName = "CITY_SEQ", initialValue = 1, allocationSize = 1)
public class Cidade implements Serializable{
    
    @Id
    @Column(name="CD_CITY", length = 200)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
    private Long id;
    
    @Column(name="DC_CITY", nullable = false, length = 200)
    private String descricao;
    
    @OneToOne
    @JoinColumn(name="CD_UF", nullable = false)
    private UF uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
