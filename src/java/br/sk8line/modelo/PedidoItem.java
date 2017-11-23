package br.sk8line.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="TB_ORDER_ITEM")
@SequenceGenerator(name="ORDER_ITEM_SEQ", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 1)
public class PedidoItem implements Serializable{
    
    @Id
    @Column(name="CD_ORDER_ITEM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ")
    private Long id;
    
    @Column(name="NU_QUANTITY", nullable = false, length = 18)
    private int quantidade;
    
    @Column(name="VL_UNIT", nullable = false, length = 18, precision = 2)
    private double valorUnitario;
    
    @ManyToOne
    @JoinColumn(name="CD_ORDER", nullable = false)
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name="CD_PRODUCT", nullable = false)
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
