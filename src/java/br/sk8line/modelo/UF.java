/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;


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
    
    
}
