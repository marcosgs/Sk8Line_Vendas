package br.sk8line.modulo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name="Produto.consultarTodos",
                query="Select p from Produto p")
})

@Entity
@Table(name="TB_PRODUCTS")
@SequenceGenerator(name="PRODUCT_SEQ",sequenceName="PRODUCT_SEQ",initialValue=1,allocationSize=1)
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "PRODUCT_SEQ")
    @Column(name="CD_PRODUCT")
    private Long id;
    
    @Column(name="DC_PRODUCT")
    private String nome;
    
    @Column(name="NU_PRICE")
    private float preco; 
    
    @Column(name="DT_CREATE")
    @Temporal(TemporalType.DATE)
    private Date data_Atual;

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

    public Date getData_Atual() {
        return data_Atual;
    }

    public void setData_Atual(Date data_Atual) {
        this.data_Atual = data_Atual;
    }
    
}
