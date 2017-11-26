package br.sk8line.ejb;

import br.sk8line.modelo.Pedido;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PedidoLocal {
    
    public Pedido salvar(Pedido u) throws Exception;
    
    public Pedido consultarPorId (Long id);
    
    public List<Pedido> consultarTodos();
    
    public void remover(Long id)throws Exception;
}
