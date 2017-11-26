package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.jboss.weld.bean.AbstractBean;

@Entity
@Table(name="TB_REVENUES_ITEM")
@SequenceGenerator(name="REVENUES_ITEMS_SEQ", sequenceName = "REVENUES_ITEMS_SEQ", initialValue = 1, allocationSize = 1)
public class FaturamentoItem implements Serializable{
    
    @Id
    @Column(name="CD_REVENUES_ITEM",length = 18)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVENUES_ITEMS_SEQ")
    private Long id;
    
    @Column(name="NU_QUANTITY", nullable = false , length = 18)
    private int quantidade;
    
    @Column(name="VL_UNIT", nullable = false, length = 18, precision = 2)
    private double valorUnitario;
    
    @ManyToOne
    @JoinColumn(name = "CD_REVENUES",nullable = false)
    private Faturamento faturamento;
    
    @ManyToOne
    @JoinColumn(name = "CD_PRODUCT", nullable = false)
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Faturamento getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Faturamento faturamento) {
        this.faturamento = faturamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
