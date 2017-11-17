package br.sk8line.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="TB_CLIENTS")
public class Cliente {
    
    @Id
    private Long id;
    
    @Column(name="DC_CLIENT",nullable = false,length = 200)
    private String nome;

    @Column(name="IN_TYPE_CLIENT")
    private String tipoCliente;
    
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
    
    
    
    
    
}
