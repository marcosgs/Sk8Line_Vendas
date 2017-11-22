
package br.sk8line.dao;

import br.sk8line.modelo.Cliente;
import javax.persistence.EntityManager;


public class ClienteDAO {
    
    private EntityManager em;
    
    public ClienteDAO (EntityManager em){
        this.em = em;
    }
    
    public Cliente salvar(Cliente c) throws Exception{
        if(c.getId()==null){
            em.persist(c);
        }else{
            if(!em.contains(c)){
                if (em.find(Cliente.class, c.getId())==null){
                    throw new Exception("Cliente não Encontrado");
                }
            }
            em.merge(c);
        }
        return c;
    }
    
    public Cliente consultarPorId(Long id){
        return em.find(Cliente.class, id);
    }
    
    public void remover(Long id){
        Cliente c = consultarPorId(id);
        em.remove(c);
    }
    
    
}
