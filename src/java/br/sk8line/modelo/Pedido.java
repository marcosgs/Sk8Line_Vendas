package br.sk8line.modelo;

import br.sk8line.modelo.Cliente;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {

    @Id
    private Long ID;
    
    @OneToOne
    private Cliente cliente;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    
}
