package br.sk8line.ejb;

import br.sk8line.dao.PedidoDAO;
import br.sk8line.modelo.Pedido;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class PedidoBean implements PedidoLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;

    @Override
    public Pedido salvar(Pedido u) throws Exception {
        PedidoDAO dao = new PedidoDAO(em);
        return dao.salvar(u);
    }

    @Override
    public Pedido consultarPorId(Long id) {
        PedidoDAO dao = new PedidoDAO(em);
        return dao.consultarPorId(id);
    }
    
    @Override
    public List<Pedido> consultarTodos(){
        PedidoDAO dao = new PedidoDAO(em);
        return dao.consultarTodos();
    }
    
    @Override
    public void remover(Long id)throws Exception {
        PedidoDAO dao = new PedidoDAO(em);
        dao.remover(id);
    }
    
}
