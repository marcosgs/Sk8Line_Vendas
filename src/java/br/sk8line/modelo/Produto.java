package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "Produto.consultarTodos",
                query = "Select p from Produto p")
})

@Entity
@Table(name="TB_PRODUCTS")
@SequenceGenerator(name="PRODUCT_SEQ",sequenceName="PRODUCT_SEQ",initialValue=1,allocationSize=1)
public class Produto implements Serializable {
    
    @Id
    @Column(name="CD_PRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "PRODUCT_SEQ")
    private Long id;
    
    @Column(name="DC_PRODUCT", nullable = false, length = 200)
    private String nome;
    
    @Column(name="NU_PRICE_SALE", nullable = false, length = 18, precision = 2)
    private float preco; 
    
    @OneToOne
    @JoinColumn (name="CD_CATEGORY")
    private Categoria categoria;
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    
    @Column(name="DT_LAST_UPD")
    @Temporal(TemporalType.DATE)
    private Date dataAtual;

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
