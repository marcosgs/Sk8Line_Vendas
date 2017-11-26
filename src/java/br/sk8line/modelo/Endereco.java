package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@NamedQueries({
    @NamedQuery(name = "Endereco.consultarTodos",
                query = "Select e from Endereco e"
    ),
    
    @NamedQuery(name="Endereco.consultaPorCliente",
                query = "select e from Endereco c " +
                        " where e.cliente.id = :cliente"
    )
})

@Entity
@Table(name="TB_ADDRESS")
@SequenceGenerator(name="ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
public class Endereco implements Serializable {
    
    @Id
    @Column(name="CD_ADDRESS", length = 18)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    private Long id;
    
    @Column(name="DC_ADDRESS", nullable = false, length = 200)
    private String descricao;
    
    @Column(name="DC_DISTRICT", nullable = false, length = 200)
    private String bairro;
    
    @Column(name="IN_TYPE_ADDRESS", nullable = true, length = 1)
    private String indTipoEndereco;
   
    @ManyToOne(targetEntity = Cliente.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="CD_CLIENT")
    private Cliente cliente;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_CITY")
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
