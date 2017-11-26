package br.sk8line.ejb;

import br.sk8line.dao.CategoriaDAO;
import br.sk8line.modelo.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoriaBean implements CategoriaLocal{
    
    @PersistenceContext(unitName="Sk8Line_VendasPU")
    private EntityManager em;
    
    @Override
    public Categoria salvar(Categoria c) throws Exception{
        CategoriaDAO dao = new CategoriaDAO(em);
        return dao.salvar(c) ;
    }
    
    @Override
    public Categoria consultarPorId(Long id){
        CategoriaDAO dao = new CategoriaDAO(em);
        return dao.consultarPorId(id);
    }
    
    @Override
    public void remover(Long id){
        CategoriaDAO dao = new CategoriaDAO(em);
        dao.remover(id);
    }

    @Override
    public List<Categoria> consultarTodos() {
        CategoriaDAO dao = new CategoriaDAO(em);
        return dao.consultarTodos();
    }
    
}
