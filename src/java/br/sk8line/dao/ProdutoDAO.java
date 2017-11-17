package br.sk8line.dao;

import br.sk8line.modelo.Produto;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

public class ProdutoDAO {
    
    private EntityManager em;
    
    public Produto salvar(Produto p)throws Exception{
        if (p.getId()==null){
            em.persist(p);
        }else{
            if(!em.contains(p)){
                if(em.find(Produto.class, p.getId())==null)
                    throw new Exception ("Produto não encontrado");
            }
            em.merge(p);
        }
        return p;
    }
    
    public Produto consultarPorID(Long id){
        return em.find(Produto.class, id);
    }
    
    public List<Produto> consultarTodos() {
        Query consulta = em.createNamedQuery("Produto.consultarTodos");
        return consulta.getResultList();
    }
    
    public void remover(Long id){
        Produto p = consultarPorID(id);
        em.remove(p);
    }
}
