package br.sk8line.dao;

import br.sk8line.modelo.Cidade;
import javax.persistence.EntityManager;

public class CidadeDAO {
    
    private EntityManager em;
    
    public CidadeDAO(EntityManager em){
        this.em = em;
    }
    
    public Cidade salvar(Cidade c)throws Exception{
        if(c.getId() == null){
            em.persist(c);
        }else{
            if(!em.contains(c)){
                if(em.find(Cidade.class, c.getId()) == null){
                    throw new Exception("Falha ao persistir usuário!");
                }
            }
            em.merge(c);
        }
        
        return c;
    }
    
    public Cidade consultarPorId(Long id){
        return em.find(Cidade.class, id);
    }
    
    public void remover(Long id){
        Cidade c = consultarPorId(id);
        em.remove(c);
    }
}
