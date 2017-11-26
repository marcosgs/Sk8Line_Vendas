package br.sk8line.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jboss.weld.bean.AbstractBean;

@NamedQueries({
    @NamedQuery(name="Pedido.consultarTodos",
            query="select p "+
                  "from Pedido p"
    ),
    
    @NamedQuery(name="Pedido.consultaPorStatus",
                query = "select p from Pedido p " +
                        " where p.status = :status"
    )
})

@Entity
@Table(name="TB_ORDER")
@SequenceGenerator(name="ORDER_SEQ",sequenceName = "ORDER_SEQ", allocationSize = 1, initialValue = 1)
public class Pedido implements Serializable{

    @Id
    @Column(name="CD_ORDER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    private Long id;
    
    @Column(name="DT_ORDER", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido ;
    
    @Column(name="CD_STATUS", nullable = false, length = 1)
    private String status;
    
    @Column(name="VL_DISCOUNT", length=18, precision = 2)
    private double desconto;
    
    @Column(name="VL_TOTAL", nullable = false, length=18, precision = 2)
    private double valorTotal;
    
    @OneToOne
    @JoinColumn(name="CD_CLIENT", nullable = false)
    private Cliente cliente;
    
    
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
