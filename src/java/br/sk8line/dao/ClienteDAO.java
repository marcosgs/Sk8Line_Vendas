
package br.sk8line.dao;

import br.sk8line.modelo.Cliente;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ClienteDAO {
    
    private EntityManager em;
    
    public ClienteDAO (EntityManager em){
        this.em = em;
    }
    
    public Cliente salvar(Cliente c) throws Exception{
        
        Date dataAtual = new Date();
        c.setDataAtual(dataAtual);
        
        if(c.getId()==null){
            //Atribui a data atual ao
            c.setDataCriacao(dataAtual);
            
            em.persist(c);
        }else{
            if(!em.contains(c)){
                if (em.find(Cliente.class, c.getId())==null){
                    throw new Exception("Falha ao persistir cliente!");
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
    
    public List<Cliente> consultarTodos(){
        Query consulta = em.createNamedQuery("Cliente.consultarTodos");
        return consulta.getResultList();
    }
}
