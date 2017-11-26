package br.sk8line.dao;

import br.sk8line.modelo.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PedidoDAO {
    
    private EntityManager em;
    
    public PedidoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Pedido salvar(Pedido p)throws Exception{
        if(p.getId()==null){
            em.persist(p);
        }else{
            if(!em.contains(p)){
                if(em.find(Pedido.class, p.getId())==null){
                    throw new Exception("Falha ao persistir pedido");
                }
            }
            em.merge(p);
        }
        return p;
    }
    
    public Pedido consultarPorId(Long id){
        return em.find(Pedido.class, id);
    }
    
    public void remover(Long id)throws Exception{
        Pedido p = consultarPorId(id);
        
        if (p.getStatus().equals("F")){
            throw new Exception("Pedido já faturado! Não pode ser excluído!");
        }
        
        em.remove(p);
    }
    
    public List<Pedido> consultarTodos(){
        Query consulta = em.createNamedQuery("Pedido.consultarTodos");
        return consulta.getResultList();
    }
}
