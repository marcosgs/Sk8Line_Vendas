package br.sk8line.ejb;

import br.sk8line.dao.ClienteDAO;
import br.sk8line.modelo.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteBean {
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    public Cliente salvar(Cliente c) throws Exception{
        ClienteDAO dao = new ClienteDAO(em);
        return dao.salvar(c) ;
    }
    
    public Cliente consultarPorId(Long id){
        ClienteDAO dao = new ClienteDAO(em);
        return dao.consultarPorId(id);
    }
    
    public void remover(Long id){
        ClienteDAO dao = new ClienteDAO(em);
        dao.remover(id);
    }
    
}
