package br.sk8line.dao;

import br.sk8line.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CategoriaDAO {
    private EntityManager em;
    
    public CategoriaDAO(EntityManager em){
        this.em = em;
    }
    
    public Categoria salvar(Categoria c)throws Exception{
        if(c.getId()== null){
            em.persist(c);
        }else{
            if (!em.contains(c)){
                if(em.find(Categoria.class, c.getId())==null){
                    throw new Exception("Falha ao persistir categoria");
                }
            }
            em.merge(c);
        }
        return c;
    }
    
    public Categoria consultarPorId(Long id){
        return em.find(Categoria.class, id);
    }
    
    public void remover(Long id){
        Categoria c = consultarPorId(id);
        em.remove(c);
    }
    
    public List<Categoria> consultarTodos(){
        Query consulta = em.createNamedQuery("Categoria.consultarTodos");
        return consulta.getResultList();
    }
}
