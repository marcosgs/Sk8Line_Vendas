package br.sk8line.dao;

import br.sk8line.modelo.Pedido;
import javax.persistence.EntityManager;

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
    
    public void remover(Long id){
        Pedido p = consultarPorId(id);
        em.remove(p);
    }
}
