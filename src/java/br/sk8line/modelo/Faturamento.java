package br.sk8line.modelo;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="TB_REVENUES")
@SequenceGenerator(name="REVENUES_SEQ", sequenceName = "REVENUES_SEQ", initialValue = 1, allocationSize = 1)
public class Faturamento implements Serializable{
    
    @Id
    @Column(name = "CD_REVENUES", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "REVENUES_SEQ" )
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="CD_ORDER", nullable = false)
    private Pedido pedido;
    
    @OneToOne
    @JoinColumn(name = "CD_CLIENT", nullable = false)
    private Cliente cliente;
    
    @Column(name="CD_STATUS", nullable = false, length = 1)
    private String status;
    
    @Column(name="CD_STATUS_DELIVERY", nullable = false, length = 1)
    private String statusEntrega;
    
    @Column(name="DT_REVENUES", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFaturamento;
    
    @Column(name="DT_DELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega;
    
    @Column(name="VL_DISCOUNT", nullable = false)
    private double valorDesconto;
    
    @Column(name="VL_TOTAL", nullable = false, length = 18, precision = 2)
    private double valorTotal;

    @OneToMany
    @JoinColumn(name = "CD_REVENUES",nullable = false)
    private List<FaturamentoItem> Itens;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public Date getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(Date dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<FaturamentoItem> getItens() {
        return Itens;
    }

    public void setItens(List<FaturamentoItem> Itens) {
        this.Itens = Itens;
    }
    
    
}
