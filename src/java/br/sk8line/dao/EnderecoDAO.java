package br.sk8line.dao;

import br.sk8line.modelo.Cliente;
import br.sk8line.modelo.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoDAO {
    
    private EntityManager em;
    
    public EnderecoDAO(EntityManager em){
        this.em = em;
    }
    
    public Endereco salvar(Endereco e)throws Exception{
        if (e.getId()== null){
            em.persist(e);
        }else{
            if( !em.contains(e)){
                if (em.find(Endereco.class, e.getId()) == null){
                    throw new Exception ("Falha ao persistir endereço!");
                }
            }
            
            em.merge(e);
        }
        return e;
    }
    
    public Endereco consultarPorId(Long id){
        return em.find(Endereco.class, id);
    }
    
    public void remover(Long id){
        Endereco e = consultarPorId(id);
        em.remove(e);
    }
    
    public List<Endereco> consultarTodos(){
        Query consulta = em.createNamedQuery("Endereco.consultarTodos");
        return consulta.getResultList();
    }
    
    public List<Endereco> consultaPorCliente(Long clienteID) {
        Query consulta = em.createNamedQuery("Endereco.consultaPorCliente")
                .setParameter("cliente", clienteID);
        
        return consulta.getResultList();
    }
}
