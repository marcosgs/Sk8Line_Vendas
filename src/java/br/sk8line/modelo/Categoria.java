package br.sk8line.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="TB_CATEGORY")
@SequenceGenerator(name="CATEGORY_SEQ", sequenceName = "CATEGORY_SEQ", initialValue = 1, allocationSize=1)
public class Categoria implements Serializable{
    
    @Id
    @Column(name= "CD_CATEGORY" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CATEGORY_SEQ")
    private Long id;
    
    @Column(name="DC_CATEGORY", nullable = false)
    private String descricao;
    
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
    
}
