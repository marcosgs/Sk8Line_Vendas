package br.sk8line.ejb;

import br.sk8line.dao.ClienteDAO;
import br.sk8line.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteBean implements ClienteLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    @Override
    public Cliente salvar(Cliente c) throws Exception{
        ClienteDAO dao = new ClienteDAO(em);
        return dao.salvar(c) ;
    }
    
    @Override
    public Cliente consultarPorId(Long id){
        ClienteDAO dao = new ClienteDAO(em);
        return dao.consultarPorId(id);
    }
    
    @Override
    public void remover(Long id){
        ClienteDAO dao = new ClienteDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Cliente> consultarTodos() {
        ClienteDAO dao = new ClienteDAO(em);
        return dao.consultarTodos();
    }
    
}
