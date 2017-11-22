package br.sk8line.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable{

    @Id
    private Long id;
    
    @Column(name="DT_ORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido ;
    
    @Column(name="CD_STATUS", nullable = false, length = 1)
    private String status;
    
    @Column(name="VL_DISCOUNT", length=18, precision = 2)
    private double desconto;
    
    @Column(name="VL_TOTAL", nullable = false, length=18, precision = 2)
    private double valorTotal;
    
    @OneToOne
    private Cliente cliente;
    
    @OneToMany
    @JoinColumn(name="CD_ORDER")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
}
