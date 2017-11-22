package br.sk8line.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.sk8line.modelo.Produto;
import br.sk8line.dao.ProdutoDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class ProdutoBean implements ProdutoLocal{
    
    @PersistenceContext(unitName = "Sk8Line_VendasPU")
    private EntityManager em;
    
    public Produto Salvar(Produto p) throws Exception{
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.salvar(p);
    }

    @Override
    public Produto consultarPorId(Long id) {
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.consultarPorID(id);
    }

    @Override
    public List<Produto> consultarTodos() {
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.consultarTodos();
    }

    @Override
    public void remover(Long id) {
        ProdutoDAO dao = new ProdutoDAO(em);
        dao.remover(id);
    }
    
}
