package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
@Table(name="TB_ADDRESS")
public class Endereco implements Serializable {
    
    @Id
    @Column(name="CD_ADDRESS")
    private Long id;
    
    @Column(name="DC_ADDRESS")
    private String descricao;
    
    @Column(name="DC_DISTRICT")
    private String bairro;
    
    @Column(name="IN_TYPE_ADDRESS", length = 1)
    private String indTipoEndereco;
   
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Cidade cidade;

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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getIndTipoEndereco() {
        return indTipoEndereco;
    }

    public void setIndTipoEndereco(String indTipoEndereco) {
        this.indTipoEndereco = indTipoEndereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    
}
