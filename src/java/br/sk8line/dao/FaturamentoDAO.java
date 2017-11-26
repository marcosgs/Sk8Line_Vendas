package br.sk8line.dao;

import br.sk8line.modelo.Faturamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FaturamentoDAO {
    
    private EntityManager em;
    
    public FaturamentoDAO(EntityManager em) {
        this.em = em;
    }
    
    public Faturamento salvar(Faturamento f)throws Exception{
        if(f.getId()==null){
            em.persist(f);
        }else{
            if(!em.contains(f)){
                if(em.find(Faturamento.class, f.getId())==null){
                    throw new Exception("Falha ao persistir fatura!");
                }
            }
            em.merge(f);
        }
        return f;
    }
    
    public Faturamento consultarPorId(Long id){
        return em.find(Faturamento.class, id);
    }
    
    public List<Faturamento> consultarTodos(){
        Query consulta = em.createNamedQuery("Faturamento.consultarTodos");
        return consulta.getResultList();
    }
}
