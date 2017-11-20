package br.sk8line.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.sk8line.modelo.Produto;
import br.sk8line.dao.ProdutoDAO;

public class ProdutoBean {
    
    @PersistenceContext(unitName = "Sk8Line_VendasPU")
    private EntityManager em;
    
    public Produto Salvar(Produto p) throws Exception{
        ProdutoDAO dao = new ProdutoDAO();
        return dao.salvar(p);
    }
    
    
    
}
